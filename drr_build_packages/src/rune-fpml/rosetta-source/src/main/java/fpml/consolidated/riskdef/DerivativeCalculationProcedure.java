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
import fpml.consolidated.riskdef.meta.DerivativeCalculationProcedureMeta;
import fpml.consolidated.shared.PricingStructureReference;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A description of how a numerical derivative is computed.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A description of how a numerical derivative is computed.
 *
 */
@RosettaDataType(value="DerivativeCalculationProcedure", builder=DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DerivativeCalculationProcedure", model="fpml", builder=DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilderImpl.class, version="2.1.1")
public interface DerivativeCalculationProcedure extends RosettaModelObject {

	DerivativeCalculationProcedureMeta metaData = new DerivativeCalculationProcedureMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method by which a derivative is computed, e.g. analytic, numerical model, perturbation, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method by which a derivative is computed, e.g. analytic, numerical model, perturbation, etc.
	 *
	 */
	DerivativeCalculationMethod getMethod();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The size and direction of the perturbation used to compute the derivative, e.g. 0.0001 = 1 bp.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The size and direction of the perturbation used to compute the derivative, e.g. 0.0001 = 1 bp.
	 *
	 */
	BigDecimal getPerturbationAmount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The value is calculated by perturbing by the perturbationAmount and then the negative of the perturbationAmount and then averaging the two values (i.e. the value is half of the difference between perturbing up and perturbing down).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The value is calculated by perturbing by the perturbationAmount and then the negative of the perturbationAmount and then averaging the two values (i.e. the value is half of the difference between perturbing up and perturbing down).
	 *
	 */
	Boolean getAveraged();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of perturbation, if any, used to compute the derivative (Absolute vs Relative).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of perturbation, if any, used to compute the derivative (Absolute vs Relative).
	 *
	 */
	PerturbationType getPerturbationType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The formula used to compute the derivative (perhaps could be updated to use the Formula type in EQS.).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The formula used to compute the derivative (perhaps could be updated to use the Formula type in EQS.).
	 *
	 */
	String getDerivativeFormula();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the replacement version of the market input, e.g. a bumped yield curve.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the replacement version of the market input, e.g. a bumped yield curve.
	 *
	 */
	PricingStructureReference getReplacementMarketInput();

	/*********************** Build Methods  ***********************/
	DerivativeCalculationProcedure build();
	
	DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder toBuilder();
	
	static DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder builder() {
		return new DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DerivativeCalculationProcedure> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DerivativeCalculationProcedure> getType() {
		return DerivativeCalculationProcedure.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("method"), processor, DerivativeCalculationMethod.class, getMethod());
		processor.processBasic(path.newSubPath("perturbationAmount"), BigDecimal.class, getPerturbationAmount(), this);
		processor.processBasic(path.newSubPath("averaged"), Boolean.class, getAveraged(), this);
		processRosetta(path.newSubPath("perturbationType"), processor, PerturbationType.class, getPerturbationType());
		processor.processBasic(path.newSubPath("derivativeFormula"), String.class, getDerivativeFormula(), this);
		processRosetta(path.newSubPath("replacementMarketInput"), processor, PricingStructureReference.class, getReplacementMarketInput());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DerivativeCalculationProcedureBuilder extends DerivativeCalculationProcedure, RosettaModelObjectBuilder {
		DerivativeCalculationMethod.DerivativeCalculationMethodBuilder getOrCreateMethod();
		@Override
		DerivativeCalculationMethod.DerivativeCalculationMethodBuilder getMethod();
		PerturbationType.PerturbationTypeBuilder getOrCreatePerturbationType();
		@Override
		PerturbationType.PerturbationTypeBuilder getPerturbationType();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreateReplacementMarketInput();
		@Override
		PricingStructureReference.PricingStructureReferenceBuilder getReplacementMarketInput();
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setMethod(DerivativeCalculationMethod method);
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setPerturbationAmount(BigDecimal perturbationAmount);
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setAveraged(Boolean averaged);
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setPerturbationType(PerturbationType perturbationType);
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setDerivativeFormula(String derivativeFormula);
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setReplacementMarketInput(PricingStructureReference replacementMarketInput);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("method"), processor, DerivativeCalculationMethod.DerivativeCalculationMethodBuilder.class, getMethod());
			processor.processBasic(path.newSubPath("perturbationAmount"), BigDecimal.class, getPerturbationAmount(), this);
			processor.processBasic(path.newSubPath("averaged"), Boolean.class, getAveraged(), this);
			processRosetta(path.newSubPath("perturbationType"), processor, PerturbationType.PerturbationTypeBuilder.class, getPerturbationType());
			processor.processBasic(path.newSubPath("derivativeFormula"), String.class, getDerivativeFormula(), this);
			processRosetta(path.newSubPath("replacementMarketInput"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getReplacementMarketInput());
		}
		

		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder prune();
	}

	/*********************** Immutable Implementation of DerivativeCalculationProcedure  ***********************/
	class DerivativeCalculationProcedureImpl implements DerivativeCalculationProcedure {
		private final DerivativeCalculationMethod method;
		private final BigDecimal perturbationAmount;
		private final Boolean averaged;
		private final PerturbationType perturbationType;
		private final String derivativeFormula;
		private final PricingStructureReference replacementMarketInput;
		
		protected DerivativeCalculationProcedureImpl(DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder builder) {
			this.method = ofNullable(builder.getMethod()).map(f->f.build()).orElse(null);
			this.perturbationAmount = builder.getPerturbationAmount();
			this.averaged = builder.getAveraged();
			this.perturbationType = ofNullable(builder.getPerturbationType()).map(f->f.build()).orElse(null);
			this.derivativeFormula = builder.getDerivativeFormula();
			this.replacementMarketInput = ofNullable(builder.getReplacementMarketInput()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("method")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("method")
		public DerivativeCalculationMethod getMethod() {
			return method;
		}
		
		@Override
		@RosettaAttribute("perturbationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("perturbationAmount")
		public BigDecimal getPerturbationAmount() {
			return perturbationAmount;
		}
		
		@Override
		@RosettaAttribute("averaged")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averaged")
		public Boolean getAveraged() {
			return averaged;
		}
		
		@Override
		@RosettaAttribute("perturbationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("perturbationType")
		public PerturbationType getPerturbationType() {
			return perturbationType;
		}
		
		@Override
		@RosettaAttribute("derivativeFormula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("derivativeFormula")
		public String getDerivativeFormula() {
			return derivativeFormula;
		}
		
		@Override
		@RosettaAttribute("replacementMarketInput")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("replacementMarketInput")
		public PricingStructureReference getReplacementMarketInput() {
			return replacementMarketInput;
		}
		
		@Override
		public DerivativeCalculationProcedure build() {
			return this;
		}
		
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder toBuilder() {
			DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder builder) {
			ofNullable(getMethod()).ifPresent(builder::setMethod);
			ofNullable(getPerturbationAmount()).ifPresent(builder::setPerturbationAmount);
			ofNullable(getAveraged()).ifPresent(builder::setAveraged);
			ofNullable(getPerturbationType()).ifPresent(builder::setPerturbationType);
			ofNullable(getDerivativeFormula()).ifPresent(builder::setDerivativeFormula);
			ofNullable(getReplacementMarketInput()).ifPresent(builder::setReplacementMarketInput);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeCalculationProcedure _that = getType().cast(o);
		
			if (!Objects.equals(method, _that.getMethod())) return false;
			if (!Objects.equals(perturbationAmount, _that.getPerturbationAmount())) return false;
			if (!Objects.equals(averaged, _that.getAveraged())) return false;
			if (!Objects.equals(perturbationType, _that.getPerturbationType())) return false;
			if (!Objects.equals(derivativeFormula, _that.getDerivativeFormula())) return false;
			if (!Objects.equals(replacementMarketInput, _that.getReplacementMarketInput())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (method != null ? method.hashCode() : 0);
			_result = 31 * _result + (perturbationAmount != null ? perturbationAmount.hashCode() : 0);
			_result = 31 * _result + (averaged != null ? averaged.hashCode() : 0);
			_result = 31 * _result + (perturbationType != null ? perturbationType.hashCode() : 0);
			_result = 31 * _result + (derivativeFormula != null ? derivativeFormula.hashCode() : 0);
			_result = 31 * _result + (replacementMarketInput != null ? replacementMarketInput.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeCalculationProcedure {" +
				"method=" + this.method + ", " +
				"perturbationAmount=" + this.perturbationAmount + ", " +
				"averaged=" + this.averaged + ", " +
				"perturbationType=" + this.perturbationType + ", " +
				"derivativeFormula=" + this.derivativeFormula + ", " +
				"replacementMarketInput=" + this.replacementMarketInput +
			'}';
		}
	}

	/*********************** Builder Implementation of DerivativeCalculationProcedure  ***********************/
	class DerivativeCalculationProcedureBuilderImpl implements DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder {
	
		protected DerivativeCalculationMethod.DerivativeCalculationMethodBuilder method;
		protected BigDecimal perturbationAmount;
		protected Boolean averaged;
		protected PerturbationType.PerturbationTypeBuilder perturbationType;
		protected String derivativeFormula;
		protected PricingStructureReference.PricingStructureReferenceBuilder replacementMarketInput;
		
		@Override
		@RosettaAttribute("method")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("method")
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder getMethod() {
			return method;
		}
		
		@Override
		public DerivativeCalculationMethod.DerivativeCalculationMethodBuilder getOrCreateMethod() {
			DerivativeCalculationMethod.DerivativeCalculationMethodBuilder result;
			if (method!=null) {
				result = method;
			}
			else {
				result = method = DerivativeCalculationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("perturbationAmount")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("perturbationAmount")
		public BigDecimal getPerturbationAmount() {
			return perturbationAmount;
		}
		
		@Override
		@RosettaAttribute("averaged")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averaged")
		public Boolean getAveraged() {
			return averaged;
		}
		
		@Override
		@RosettaAttribute("perturbationType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("perturbationType")
		public PerturbationType.PerturbationTypeBuilder getPerturbationType() {
			return perturbationType;
		}
		
		@Override
		public PerturbationType.PerturbationTypeBuilder getOrCreatePerturbationType() {
			PerturbationType.PerturbationTypeBuilder result;
			if (perturbationType!=null) {
				result = perturbationType;
			}
			else {
				result = perturbationType = PerturbationType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("derivativeFormula")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("derivativeFormula")
		public String getDerivativeFormula() {
			return derivativeFormula;
		}
		
		@Override
		@RosettaAttribute("replacementMarketInput")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("replacementMarketInput")
		public PricingStructureReference.PricingStructureReferenceBuilder getReplacementMarketInput() {
			return replacementMarketInput;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreateReplacementMarketInput() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (replacementMarketInput!=null) {
				result = replacementMarketInput;
			}
			else {
				result = replacementMarketInput = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("method")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("method")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setMethod(DerivativeCalculationMethod _method) {
			this.method = _method == null ? null : _method.toBuilder();
			return this;
		}
		
		@RosettaAttribute("perturbationAmount")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("perturbationAmount")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setPerturbationAmount(BigDecimal _perturbationAmount) {
			this.perturbationAmount = _perturbationAmount == null ? null : _perturbationAmount;
			return this;
		}
		
		@RosettaAttribute("averaged")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averaged")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setAveraged(Boolean _averaged) {
			this.averaged = _averaged == null ? null : _averaged;
			return this;
		}
		
		@RosettaAttribute("perturbationType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("perturbationType")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setPerturbationType(PerturbationType _perturbationType) {
			this.perturbationType = _perturbationType == null ? null : _perturbationType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("derivativeFormula")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("derivativeFormula")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setDerivativeFormula(String _derivativeFormula) {
			this.derivativeFormula = _derivativeFormula == null ? null : _derivativeFormula;
			return this;
		}
		
		@RosettaAttribute("replacementMarketInput")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("replacementMarketInput")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder setReplacementMarketInput(PricingStructureReference _replacementMarketInput) {
			this.replacementMarketInput = _replacementMarketInput == null ? null : _replacementMarketInput.toBuilder();
			return this;
		}
		
		@Override
		public DerivativeCalculationProcedure build() {
			return new DerivativeCalculationProcedure.DerivativeCalculationProcedureImpl(this);
		}
		
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder prune() {
			if (method!=null && !method.prune().hasData()) method = null;
			if (perturbationType!=null && !perturbationType.prune().hasData()) perturbationType = null;
			if (replacementMarketInput!=null && !replacementMarketInput.prune().hasData()) replacementMarketInput = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMethod()!=null && getMethod().hasData()) return true;
			if (getPerturbationAmount()!=null) return true;
			if (getAveraged()!=null) return true;
			if (getPerturbationType()!=null && getPerturbationType().hasData()) return true;
			if (getDerivativeFormula()!=null) return true;
			if (getReplacementMarketInput()!=null && getReplacementMarketInput().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder o = (DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder) other;
			
			merger.mergeRosetta(getMethod(), o.getMethod(), this::setMethod);
			merger.mergeRosetta(getPerturbationType(), o.getPerturbationType(), this::setPerturbationType);
			merger.mergeRosetta(getReplacementMarketInput(), o.getReplacementMarketInput(), this::setReplacementMarketInput);
			
			merger.mergeBasic(getPerturbationAmount(), o.getPerturbationAmount(), this::setPerturbationAmount);
			merger.mergeBasic(getAveraged(), o.getAveraged(), this::setAveraged);
			merger.mergeBasic(getDerivativeFormula(), o.getDerivativeFormula(), this::setDerivativeFormula);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DerivativeCalculationProcedure _that = getType().cast(o);
		
			if (!Objects.equals(method, _that.getMethod())) return false;
			if (!Objects.equals(perturbationAmount, _that.getPerturbationAmount())) return false;
			if (!Objects.equals(averaged, _that.getAveraged())) return false;
			if (!Objects.equals(perturbationType, _that.getPerturbationType())) return false;
			if (!Objects.equals(derivativeFormula, _that.getDerivativeFormula())) return false;
			if (!Objects.equals(replacementMarketInput, _that.getReplacementMarketInput())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (method != null ? method.hashCode() : 0);
			_result = 31 * _result + (perturbationAmount != null ? perturbationAmount.hashCode() : 0);
			_result = 31 * _result + (averaged != null ? averaged.hashCode() : 0);
			_result = 31 * _result + (perturbationType != null ? perturbationType.hashCode() : 0);
			_result = 31 * _result + (derivativeFormula != null ? derivativeFormula.hashCode() : 0);
			_result = 31 * _result + (replacementMarketInput != null ? replacementMarketInput.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DerivativeCalculationProcedureBuilder {" +
				"method=" + this.method + ", " +
				"perturbationAmount=" + this.perturbationAmount + ", " +
				"averaged=" + this.averaged + ", " +
				"perturbationType=" + this.perturbationType + ", " +
				"derivativeFormula=" + this.derivativeFormula + ", " +
				"replacementMarketInput=" + this.replacementMarketInput +
			'}';
		}
	}
}
