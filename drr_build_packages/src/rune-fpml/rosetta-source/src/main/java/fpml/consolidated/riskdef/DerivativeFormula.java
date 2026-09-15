package fpml.consolidated.riskdef;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.riskdef.meta.DerivativeFormulaMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A formula for computing a complex derivative from partial derivatives. Its value is the sum of the terms divided by the product of the denominator terms.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A formula for computing a complex derivative from partial derivatives. Its value is the sum of the terms divided by the product of the denominator terms.
 *
 */
@RosettaDataType(value="DerivativeFormula", builder=DerivativeFormula.DerivativeFormulaBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DerivativeFormula", model="fpml", builder=DerivativeFormula.DerivativeFormulaBuilderImpl.class, version="2.1.1")
public interface DerivativeFormula extends RosettaModelObject {

	DerivativeFormulaMeta metaData = new DerivativeFormulaMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A term of the formula. Its value is the product of the its coefficient and the referenced partial derivatives.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A term of the formula. Its value is the product of the its coefficient and the referenced partial derivatives.
	 *
	 */
	FormulaTerm getTerm();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A denominator term of the formula. Its value is (sum of weighted partials) ^ power.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A denominator term of the formula. Its value is (sum of weighted partials) ^ power.
	 *
	 */
	DenominatorTerm getDenominatorTerm();

	/*********************** Build Methods  ***********************/
	DerivativeFormula build();
	
	DerivativeFormula.DerivativeFormulaBuilder toBuilder();
	
	static DerivativeFormula.DerivativeFormulaBuilder builder() {
		return new DerivativeFormula.DerivativeFormulaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeFormula> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativeFormula> getType() {
		return DerivativeFormula.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("term"), processor, FormulaTerm.class, getTerm());
		processRosetta(path.newSubPath("denominatorTerm"), processor, DenominatorTerm.class, getDenominatorTerm());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeFormulaBuilder extends DerivativeFormula, RosettaModelObjectBuilder {
		FormulaTerm.FormulaTermBuilder getOrCreateTerm();
		@Override
		FormulaTerm.FormulaTermBuilder getTerm();
		DenominatorTerm.DenominatorTermBuilder getOrCreateDenominatorTerm();
		@Override
		DenominatorTerm.DenominatorTermBuilder getDenominatorTerm();
		DerivativeFormula.DerivativeFormulaBuilder setTerm(FormulaTerm term);
		DerivativeFormula.DerivativeFormulaBuilder setDenominatorTerm(DenominatorTerm denominatorTerm);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("term"), processor, FormulaTerm.FormulaTermBuilder.class, getTerm());
			processRosetta(path.newSubPath("denominatorTerm"), processor, DenominatorTerm.DenominatorTermBuilder.class, getDenominatorTerm());
		}
		

		DerivativeFormula.DerivativeFormulaBuilder prune();
	}

	/*********************** Immutable Implementation of DerivativeFormula  ***********************/
	class DerivativeFormulaImpl implements DerivativeFormula {
		private final FormulaTerm term;
		private final DenominatorTerm denominatorTerm;
		
		protected DerivativeFormulaImpl(DerivativeFormula.DerivativeFormulaBuilder builder) {
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
			this.denominatorTerm = ofNullable(builder.getDenominatorTerm()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public FormulaTerm getTerm() {
			return term;
		}
		
		@Override
		@RosettaAttribute("denominatorTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("denominatorTerm")
		public DenominatorTerm getDenominatorTerm() {
			return denominatorTerm;
		}
		
		@Override
		public DerivativeFormula build() {
			return this;
		}
		
		@Override
		public DerivativeFormula.DerivativeFormulaBuilder toBuilder() {
			DerivativeFormula.DerivativeFormulaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeFormula.DerivativeFormulaBuilder builder) {
			ofNullable(getTerm()).ifPresent(builder::setTerm);
			ofNullable(getDenominatorTerm()).ifPresent(builder::setDenominatorTerm);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeFormula _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(denominatorTerm, _that.getDenominatorTerm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (denominatorTerm != null ? denominatorTerm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeFormula {" +
				"term=" + this.term + ", " +
				"denominatorTerm=" + this.denominatorTerm +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeFormula  ***********************/
	class DerivativeFormulaBuilderImpl implements DerivativeFormula.DerivativeFormulaBuilder {
	
		protected FormulaTerm.FormulaTermBuilder term;
		protected DenominatorTerm.DenominatorTermBuilder denominatorTerm;
		
		@Override
		@RosettaAttribute("term")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("term")
		public FormulaTerm.FormulaTermBuilder getTerm() {
			return term;
		}
		
		@Override
		public FormulaTerm.FormulaTermBuilder getOrCreateTerm() {
			FormulaTerm.FormulaTermBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = FormulaTerm.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("denominatorTerm")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("denominatorTerm")
		public DenominatorTerm.DenominatorTermBuilder getDenominatorTerm() {
			return denominatorTerm;
		}
		
		@Override
		public DenominatorTerm.DenominatorTermBuilder getOrCreateDenominatorTerm() {
			DenominatorTerm.DenominatorTermBuilder result;
			if (denominatorTerm!=null) {
				result = denominatorTerm;
			}
			else {
				result = denominatorTerm = DenominatorTerm.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("term")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("term")
		@Override
		public DerivativeFormula.DerivativeFormulaBuilder setTerm(FormulaTerm _term) {
			this.term = _term == null ? null : _term.toBuilder();
			return this;
		}
		
		@RosettaAttribute("denominatorTerm")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("denominatorTerm")
		@Override
		public DerivativeFormula.DerivativeFormulaBuilder setDenominatorTerm(DenominatorTerm _denominatorTerm) {
			this.denominatorTerm = _denominatorTerm == null ? null : _denominatorTerm.toBuilder();
			return this;
		}
		
		@Override
		public DerivativeFormula build() {
			return new DerivativeFormula.DerivativeFormulaImpl(this);
		}
		
		@Override
		public DerivativeFormula.DerivativeFormulaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeFormula.DerivativeFormulaBuilder prune() {
			if (term!=null && !term.prune().hasData()) term = null;
			if (denominatorTerm!=null && !denominatorTerm.prune().hasData()) denominatorTerm = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTerm()!=null && getTerm().hasData()) return true;
			if (getDenominatorTerm()!=null && getDenominatorTerm().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeFormula.DerivativeFormulaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeFormula.DerivativeFormulaBuilder o = (DerivativeFormula.DerivativeFormulaBuilder) other;
			
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			merger.mergeRosetta(getDenominatorTerm(), o.getDenominatorTerm(), this::setDenominatorTerm);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeFormula _that = getType().cast(o);
		
			if (!Objects.equals(term, _that.getTerm())) return false;
			if (!Objects.equals(denominatorTerm, _that.getDenominatorTerm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			_result = 31 * _result + (denominatorTerm != null ? denominatorTerm.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeFormulaBuilder {" +
				"term=" + this.term + ", " +
				"denominatorTerm=" + this.denominatorTerm +
			'}';
		}
	}
}
