package za.ac.sun.cs.semdiff.ast.statements;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ConstructorInvocation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.Type;

import za.ac.sun.cs.semdiff.ast.expressions.DiffExpression;
import za.ac.sun.cs.semdiff.ast.expressions.DiffType;
import za.ac.sun.cs.semdiff.jdtvisitors.ExpressionVisitor;
import za.ac.sun.cs.semdiff.matcher.DiffASTMatcher;
import za.ac.sun.cs.semdiff.visitors.DiffVisitor;

// ConstructorInvocation:
//    [ < Type { , Type } > ]
//                    this ( [ Expression { , Expression } ] ) ;
public class DiffConstructorInvocation extends DiffStatement {

	private List<DiffType> types = null;
	private List<DiffExpression> arguments = null;

	@SuppressWarnings("unchecked")
	public DiffConstructorInvocation(ConstructorInvocation stmt) {
		super(stmt);

		List<Type> typeArguments = stmt.typeArguments();
		this.types = new ArrayList<DiffType>();
		for (Type t : typeArguments) {
			this.types.add(new DiffType(t));
		}

		this.arguments = new ArrayList<DiffExpression>();
		List<Expression> expressions = stmt.arguments();
		for (Expression e : expressions) {
			e.accept(ExpressionVisitor.getExpressionVisitor());
			this.arguments.add(ExpressionVisitor.getExpressionVisitor()
					.getExpression());
		}

	}

	public List<DiffType> getTypes() {
		return this.types;
	}

	public List<DiffExpression> getArguments() {
		return this.arguments;
	}

	@Override
	public boolean subtreeMatch0(DiffASTMatcher matcher, Object other) {
		return matcher.match(this, other);
	}

	@Override
	public void accept0(DiffVisitor visitor) {
		boolean visitChildren = visitor.visit(this);
		if (visitChildren) {
			acceptChildren(visitor, getTypes());
			acceptChildren(visitor, getArguments());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (this.types.size() > 0) {
			sb.append("<");
			String prefix = "";
			for (DiffType tp : this.types) {
				sb.append(prefix);
				prefix = ", ";
				sb.append(tp.toString());
			}
			sb.append(">");
		}

		sb.append(" this ");

		sb.append(" (");
		String prefix = "";
		for (DiffExpression e : this.arguments) {
			sb.append(prefix);
			prefix = ", ";
			sb.append(e.toString());
		}
		sb.append(")");

		return sb.toString();
	}

}
