package fpml.consolidated.riskdef;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.asset.AssetReference;
import fpml.consolidated.riskdef.meta.PricingParameterDerivativeMeta;
import fpml.consolidated.shared.PricingStructureReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A definition of the mathematical derivative with respect to a specific pricing parameter.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A definition of the mathematical derivative with respect to a specific pricing parameter.
 *
 */
@RosettaDataType(value="PricingParameterDerivative", builder=PricingParameterDerivative.PricingParameterDerivativeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="PricingParameterDerivative", model="fpml", builder=PricingParameterDerivative.PricingParameterDerivativeBuilderImpl.class, version="2.1.1")
public interface PricingParameterDerivative extends RosettaModelObject {

	PricingParameterDerivativeMeta metaData = new PricingParameterDerivativeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A description, if needed, of how the derivative is computed.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A description, if needed, of how the derivative is computed.
	 *
	 */
	String getDescription();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. A reference to the pricing input parameter to which the sensitivity is computed. If it is omitted, the derivative definition is generic, and applies to any input point in the valuation set.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision DEPRECATED. A reference to the pricing input parameter to which the sensitivity is computed. If it is omitted, the derivative definition is generic, and applies to any input point in the valuation set.
	 *
	 */
	AssetOrTermPointOrPricingStructureReference getParameterReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the asset to which the sensitivity is computed. If it is omitted, the derivative definition is generic, and applies to any input point in the valuation set.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the asset to which the sensitivity is computed. If it is omitted, the derivative definition is generic, and applies to any input point in the valuation set.
	 *
	 */
	AssetReference getAssetReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the term point to which the sensitivity is computed. If it is omitted, the derivative definition is generic, and applies to any input point in the valuation set.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the term point to which the sensitivity is computed. If it is omitted, the derivative definition is generic, and applies to any input point in the valuation set.
	 *
	 */
	TermPointReference getTermPointReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the pricing structure to which the sensitivity is computed. If it is omitted, the derivative definition is generic, and applies to any input point in the valuation set.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the pricing structure to which the sensitivity is computed. If it is omitted, the derivative definition is generic, and applies to any input point in the valuation set.
	 *
	 */
	PricingStructureReference getPricingStructureReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference(s) to the pricing input dates that are shifted when the sensitivity is computed. Depending on the time advance method used, this list could vary. Used for describing time-advance derivatives (theta, carry, etc.)
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference(s) to the pricing input dates that are shifted when the sensitivity is computed. Depending on the time advance method used, this list could vary. Used for describing time-advance derivatives (theta, carry, etc.)
	 *
	 */
	List<? extends ValuationReference> getInputDateReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method by which a derivative is computed, e.g. analytic, numerical model, perturbation, etc., and the corresponding parameters
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method by which a derivative is computed, e.g. analytic, numerical model, perturbation, etc., and the corresponding parameters
	 *
	 */
	DerivativeCalculationProcedure getCalculationProcedure();

	/*********************** Build Methods  ***********************/
	PricingParameterDerivative build();
	
	PricingParameterDerivative.PricingParameterDerivativeBuilder toBuilder();
	
	static PricingParameterDerivative.PricingParameterDerivativeBuilder builder() {
		return new PricingParameterDerivative.PricingParameterDerivativeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends PricingParameterDerivative> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends PricingParameterDerivative> getType() {
		return PricingParameterDerivative.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
		processRosetta(path.newSubPath("parameterReference"), processor, AssetOrTermPointOrPricingStructureReference.class, getParameterReference());
		processRosetta(path.newSubPath("assetReference"), processor, AssetReference.class, getAssetReference());
		processRosetta(path.newSubPath("termPointReference"), processor, TermPointReference.class, getTermPointReference());
		processRosetta(path.newSubPath("pricingStructureReference"), processor, PricingStructureReference.class, getPricingStructureReference());
		processRosetta(path.newSubPath("inputDateReference"), processor, ValuationReference.class, getInputDateReference());
		processRosetta(path.newSubPath("calculationProcedure"), processor, DerivativeCalculationProcedure.class, getCalculationProcedure());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PricingParameterDerivativeBuilder extends PricingParameterDerivative, RosettaModelObjectBuilder {
		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getOrCreateParameterReference();
		@Override
		AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getParameterReference();
		AssetReference.AssetReferenceBuilder getOrCreateAssetReference();
		@Override
		AssetReference.AssetReferenceBuilder getAssetReference();
		TermPointReference.TermPointReferenceBuilder getOrCreateTermPointReference();
		@Override
		TermPointReference.TermPointReferenceBuilder getTermPointReference();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingStructureReference();
		@Override
		PricingStructureReference.PricingStructureReferenceBuilder getPricingStructureReference();
		ValuationReference.ValuationReferenceBuilder getOrCreateInputDateReference(int index);
		@Override
		List<? extends ValuationReference.ValuationReferenceBuilder> getInputDateReference();
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getOrCreateCalculationProcedure();
		@Override
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getCalculationProcedure();
		PricingParameterDerivative.PricingParameterDerivativeBuilder setId(String id);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setDescription(String description);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setParameterReference(AssetOrTermPointOrPricingStructureReference parameterReference);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setAssetReference(AssetReference assetReference);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setTermPointReference(TermPointReference termPointReference);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setPricingStructureReference(PricingStructureReference pricingStructureReference);
		PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(ValuationReference inputDateReference);
		PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(ValuationReference inputDateReference, int idx);
		PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(List<? extends ValuationReference> inputDateReference);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setInputDateReference(List<? extends ValuationReference> inputDateReference);
		PricingParameterDerivative.PricingParameterDerivativeBuilder setCalculationProcedure(DerivativeCalculationProcedure calculationProcedure);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("description"), String.class, getDescription(), this);
			processRosetta(path.newSubPath("parameterReference"), processor, AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder.class, getParameterReference());
			processRosetta(path.newSubPath("assetReference"), processor, AssetReference.AssetReferenceBuilder.class, getAssetReference());
			processRosetta(path.newSubPath("termPointReference"), processor, TermPointReference.TermPointReferenceBuilder.class, getTermPointReference());
			processRosetta(path.newSubPath("pricingStructureReference"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getPricingStructureReference());
			processRosetta(path.newSubPath("inputDateReference"), processor, ValuationReference.ValuationReferenceBuilder.class, getInputDateReference());
			processRosetta(path.newSubPath("calculationProcedure"), processor, DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder.class, getCalculationProcedure());
		}
		

		PricingParameterDerivative.PricingParameterDerivativeBuilder prune();
	}

	/*********************** Immutable Implementation of PricingParameterDerivative  ***********************/
	class PricingParameterDerivativeImpl implements PricingParameterDerivative {
		private final String id;
		private final String description;
		private final AssetOrTermPointOrPricingStructureReference parameterReference;
		private final AssetReference assetReference;
		private final TermPointReference termPointReference;
		private final PricingStructureReference pricingStructureReference;
		private final List<? extends ValuationReference> inputDateReference;
		private final DerivativeCalculationProcedure calculationProcedure;
		
		protected PricingParameterDerivativeImpl(PricingParameterDerivative.PricingParameterDerivativeBuilder builder) {
			this.id = builder.getId();
			this.description = builder.getDescription();
			this.parameterReference = ofNullable(builder.getParameterReference()).map(f->f.build()).orElse(null);
			this.assetReference = ofNullable(builder.getAssetReference()).map(f->f.build()).orElse(null);
			this.termPointReference = ofNullable(builder.getTermPointReference()).map(f->f.build()).orElse(null);
			this.pricingStructureReference = ofNullable(builder.getPricingStructureReference()).map(f->f.build()).orElse(null);
			this.inputDateReference = ofNullable(builder.getInputDateReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.calculationProcedure = ofNullable(builder.getCalculationProcedure()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("parameterReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parameterReference")
		public AssetOrTermPointOrPricingStructureReference getParameterReference() {
			return parameterReference;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetReference")
		public AssetReference getAssetReference() {
			return assetReference;
		}
		
		@Override
		@RosettaAttribute("termPointReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termPointReference")
		public TermPointReference getTermPointReference() {
			return termPointReference;
		}
		
		@Override
		@RosettaAttribute("pricingStructureReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingStructureReference")
		public PricingStructureReference getPricingStructureReference() {
			return pricingStructureReference;
		}
		
		@Override
		@RosettaAttribute("inputDateReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("inputDateReference")
		public List<? extends ValuationReference> getInputDateReference() {
			return inputDateReference;
		}
		
		@Override
		@RosettaAttribute("calculationProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationProcedure")
		public DerivativeCalculationProcedure getCalculationProcedure() {
			return calculationProcedure;
		}
		
		@Override
		public PricingParameterDerivative build() {
			return this;
		}
		
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder toBuilder() {
			PricingParameterDerivative.PricingParameterDerivativeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(PricingParameterDerivative.PricingParameterDerivativeBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getDescription()).ifPresent(builder::setDescription);
			ofNullable(getParameterReference()).ifPresent(builder::setParameterReference);
			ofNullable(getAssetReference()).ifPresent(builder::setAssetReference);
			ofNullable(getTermPointReference()).ifPresent(builder::setTermPointReference);
			ofNullable(getPricingStructureReference()).ifPresent(builder::setPricingStructureReference);
			ofNullable(getInputDateReference()).ifPresent(builder::setInputDateReference);
			ofNullable(getCalculationProcedure()).ifPresent(builder::setCalculationProcedure);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingParameterDerivative _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(parameterReference, _that.getParameterReference())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(termPointReference, _that.getTermPointReference())) return false;
			if (!Objects.equals(pricingStructureReference, _that.getPricingStructureReference())) return false;
			if (!ListEquals.listEquals(inputDateReference, _that.getInputDateReference())) return false;
			if (!Objects.equals(calculationProcedure, _that.getCalculationProcedure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (parameterReference != null ? parameterReference.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (termPointReference != null ? termPointReference.hashCode() : 0);
			_result = 31 * _result + (pricingStructureReference != null ? pricingStructureReference.hashCode() : 0);
			_result = 31 * _result + (inputDateReference != null ? inputDateReference.hashCode() : 0);
			_result = 31 * _result + (calculationProcedure != null ? calculationProcedure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingParameterDerivative {" +
				"id=" + this.id + ", " +
				"description=" + this.description + ", " +
				"parameterReference=" + this.parameterReference + ", " +
				"assetReference=" + this.assetReference + ", " +
				"termPointReference=" + this.termPointReference + ", " +
				"pricingStructureReference=" + this.pricingStructureReference + ", " +
				"inputDateReference=" + this.inputDateReference + ", " +
				"calculationProcedure=" + this.calculationProcedure +
			'}';
		}
	}

	/*********************** Builder Implementation of PricingParameterDerivative  ***********************/
	class PricingParameterDerivativeBuilderImpl implements PricingParameterDerivative.PricingParameterDerivativeBuilder {
	
		protected String id;
		protected String description;
		protected AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder parameterReference;
		protected AssetReference.AssetReferenceBuilder assetReference;
		protected TermPointReference.TermPointReferenceBuilder termPointReference;
		protected PricingStructureReference.PricingStructureReferenceBuilder pricingStructureReference;
		protected List<ValuationReference.ValuationReferenceBuilder> inputDateReference = new ArrayList<>();
		protected DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder calculationProcedure;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("description")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("description")
		public String getDescription() {
			return description;
		}
		
		@Override
		@RosettaAttribute("parameterReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("parameterReference")
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getParameterReference() {
			return parameterReference;
		}
		
		@Override
		public AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder getOrCreateParameterReference() {
			AssetOrTermPointOrPricingStructureReference.AssetOrTermPointOrPricingStructureReferenceBuilder result;
			if (parameterReference!=null) {
				result = parameterReference;
			}
			else {
				result = parameterReference = AssetOrTermPointOrPricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("assetReference")
		public AssetReference.AssetReferenceBuilder getAssetReference() {
			return assetReference;
		}
		
		@Override
		public AssetReference.AssetReferenceBuilder getOrCreateAssetReference() {
			AssetReference.AssetReferenceBuilder result;
			if (assetReference!=null) {
				result = assetReference;
			}
			else {
				result = assetReference = AssetReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("termPointReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termPointReference")
		public TermPointReference.TermPointReferenceBuilder getTermPointReference() {
			return termPointReference;
		}
		
		@Override
		public TermPointReference.TermPointReferenceBuilder getOrCreateTermPointReference() {
			TermPointReference.TermPointReferenceBuilder result;
			if (termPointReference!=null) {
				result = termPointReference;
			}
			else {
				result = termPointReference = TermPointReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingStructureReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingStructureReference")
		public PricingStructureReference.PricingStructureReferenceBuilder getPricingStructureReference() {
			return pricingStructureReference;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingStructureReference() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (pricingStructureReference!=null) {
				result = pricingStructureReference;
			}
			else {
				result = pricingStructureReference = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("inputDateReference")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("inputDateReference")
		public List<? extends ValuationReference.ValuationReferenceBuilder> getInputDateReference() {
			return inputDateReference;
		}
		
		@Override
		public ValuationReference.ValuationReferenceBuilder getOrCreateInputDateReference(int index) {
			if (inputDateReference==null) {
				this.inputDateReference = new ArrayList<>();
			}
			return getIndex(inputDateReference, index, () -> {
						ValuationReference.ValuationReferenceBuilder newInputDateReference = ValuationReference.builder();
						return newInputDateReference;
					});
		}
		
		@Override
		@RosettaAttribute("calculationProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationProcedure")
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getCalculationProcedure() {
			return calculationProcedure;
		}
		
		@Override
		public DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getOrCreateCalculationProcedure() {
			DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder result;
			if (calculationProcedure!=null) {
				result = calculationProcedure;
			}
			else {
				result = calculationProcedure = DerivativeCalculationProcedure.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("description")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("description")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setDescription(String _description) {
			this.description = _description == null ? null : _description;
			return this;
		}
		
		@RosettaAttribute("parameterReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parameterReference")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setParameterReference(AssetOrTermPointOrPricingStructureReference _parameterReference) {
			this.parameterReference = _parameterReference == null ? null : _parameterReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("assetReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("assetReference")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setAssetReference(AssetReference _assetReference) {
			this.assetReference = _assetReference == null ? null : _assetReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termPointReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termPointReference")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setTermPointReference(TermPointReference _termPointReference) {
			this.termPointReference = _termPointReference == null ? null : _termPointReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingStructureReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingStructureReference")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setPricingStructureReference(PricingStructureReference _pricingStructureReference) {
			this.pricingStructureReference = _pricingStructureReference == null ? null : _pricingStructureReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inputDateReference")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("inputDateReference")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(ValuationReference _inputDateReference) {
			if (_inputDateReference != null) {
				this.inputDateReference.add(_inputDateReference.toBuilder());
			}
			return this;
		}
		
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(ValuationReference _inputDateReference, int idx) {
			getIndex(this.inputDateReference, idx, () -> _inputDateReference.toBuilder());
			return this;
		}
		
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder addInputDateReference(List<? extends ValuationReference> inputDateReferences) {
			if (inputDateReferences != null) {
				for (final ValuationReference toAdd : inputDateReferences) {
					this.inputDateReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("inputDateReference")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("inputDateReference")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setInputDateReference(List<? extends ValuationReference> inputDateReferences) {
			if (inputDateReferences == null) {
				this.inputDateReference = new ArrayList<>();
			} else {
				this.inputDateReference = inputDateReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationProcedure")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder setCalculationProcedure(DerivativeCalculationProcedure _calculationProcedure) {
			this.calculationProcedure = _calculationProcedure == null ? null : _calculationProcedure.toBuilder();
			return this;
		}
		
		@Override
		public PricingParameterDerivative build() {
			return new PricingParameterDerivative.PricingParameterDerivativeImpl(this);
		}
		
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder prune() {
			if (parameterReference!=null && !parameterReference.prune().hasData()) parameterReference = null;
			if (assetReference!=null && !assetReference.prune().hasData()) assetReference = null;
			if (termPointReference!=null && !termPointReference.prune().hasData()) termPointReference = null;
			if (pricingStructureReference!=null && !pricingStructureReference.prune().hasData()) pricingStructureReference = null;
			inputDateReference = inputDateReference.stream().filter(b->b!=null).<ValuationReference.ValuationReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationProcedure!=null && !calculationProcedure.prune().hasData()) calculationProcedure = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getDescription()!=null) return true;
			if (getParameterReference()!=null && getParameterReference().hasData()) return true;
			if (getAssetReference()!=null && getAssetReference().hasData()) return true;
			if (getTermPointReference()!=null && getTermPointReference().hasData()) return true;
			if (getPricingStructureReference()!=null && getPricingStructureReference().hasData()) return true;
			if (getInputDateReference()!=null && getInputDateReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationProcedure()!=null && getCalculationProcedure().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public PricingParameterDerivative.PricingParameterDerivativeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			PricingParameterDerivative.PricingParameterDerivativeBuilder o = (PricingParameterDerivative.PricingParameterDerivativeBuilder) other;
			
			merger.mergeRosetta(getParameterReference(), o.getParameterReference(), this::setParameterReference);
			merger.mergeRosetta(getAssetReference(), o.getAssetReference(), this::setAssetReference);
			merger.mergeRosetta(getTermPointReference(), o.getTermPointReference(), this::setTermPointReference);
			merger.mergeRosetta(getPricingStructureReference(), o.getPricingStructureReference(), this::setPricingStructureReference);
			merger.mergeRosetta(getInputDateReference(), o.getInputDateReference(), this::getOrCreateInputDateReference);
			merger.mergeRosetta(getCalculationProcedure(), o.getCalculationProcedure(), this::setCalculationProcedure);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getDescription(), o.getDescription(), this::setDescription);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			PricingParameterDerivative _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(description, _that.getDescription())) return false;
			if (!Objects.equals(parameterReference, _that.getParameterReference())) return false;
			if (!Objects.equals(assetReference, _that.getAssetReference())) return false;
			if (!Objects.equals(termPointReference, _that.getTermPointReference())) return false;
			if (!Objects.equals(pricingStructureReference, _that.getPricingStructureReference())) return false;
			if (!ListEquals.listEquals(inputDateReference, _that.getInputDateReference())) return false;
			if (!Objects.equals(calculationProcedure, _that.getCalculationProcedure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (description != null ? description.hashCode() : 0);
			_result = 31 * _result + (parameterReference != null ? parameterReference.hashCode() : 0);
			_result = 31 * _result + (assetReference != null ? assetReference.hashCode() : 0);
			_result = 31 * _result + (termPointReference != null ? termPointReference.hashCode() : 0);
			_result = 31 * _result + (pricingStructureReference != null ? pricingStructureReference.hashCode() : 0);
			_result = 31 * _result + (inputDateReference != null ? inputDateReference.hashCode() : 0);
			_result = 31 * _result + (calculationProcedure != null ? calculationProcedure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PricingParameterDerivativeBuilder {" +
				"id=" + this.id + ", " +
				"description=" + this.description + ", " +
				"parameterReference=" + this.parameterReference + ", " +
				"assetReference=" + this.assetReference + ", " +
				"termPointReference=" + this.termPointReference + ", " +
				"pricingStructureReference=" + this.pricingStructureReference + ", " +
				"inputDateReference=" + this.inputDateReference + ", " +
				"calculationProcedure=" + this.calculationProcedure +
			'}';
		}
	}
}
