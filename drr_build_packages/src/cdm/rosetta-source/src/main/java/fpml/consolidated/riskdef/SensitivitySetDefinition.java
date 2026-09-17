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
import fpml.consolidated.asset.QuotationCharacteristics;
import fpml.consolidated.riskdef.meta.SensitivitySetDefinitionMeta;
import fpml.consolidated.shared.PricingStructureReference;
import java.math.BigDecimal;
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
 * Provision A sensitivity report definition, consisting of a collection of sensitivity definitions.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A sensitivity report definition, consisting of a collection of sensitivity definitions.
 *
 */
@RosettaDataType(value="SensitivitySetDefinition", builder=SensitivitySetDefinition.SensitivitySetDefinitionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="SensitivitySetDefinition", model="fpml", builder=SensitivitySetDefinition.SensitivitySetDefinitionBuilderImpl.class, version="2.1.1")
public interface SensitivitySetDefinition extends RosettaModelObject {

	SensitivitySetDefinitionMeta metaData = new SensitivitySetDefinitionMeta();

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
	 * Provision The name of the sensitivity set definition, e.g. "USDLIBOR curve sensitivities".
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the sensitivity set definition, e.g. "USDLIBOR curve sensitivities".
	 *
	 */
	String getName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The default characteristics of the quotation, e.g. type, units, etc.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The default characteristics of the quotation, e.g. type, units, etc.
	 *
	 */
	QuotationCharacteristics getSensitivityCharacteristics();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Reference to the valuation scenario to which this sensitivity definition applies, e.g. a reference to the EOD valuation scenario. If not supplied, this sensitivity set definition is generic to a variety of valuation scenarios.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to the valuation scenario to which this sensitivity definition applies, e.g. a reference to the EOD valuation scenario. If not supplied, this sensitivity set definition is generic to a variety of valuation scenarios.
	 *
	 */
	ValuationScenarioReference getValuationScenarioReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The type of the pricing input to which the sensitivity is shown, e.g. a yield curve or volatility matrix.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The type of the pricing input to which the sensitivity is shown, e.g. a yield curve or volatility matrix.
	 *
	 */
	PricingInputType getPricingInputType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A reference to the pricing input to which the sensitivity is shown, e.g. a reference to a USDLIBOR yield curve.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A reference to the pricing input to which the sensitivity is shown, e.g. a reference to a USDLIBOR yield curve.
	 *
	 */
	PricingStructureReference getPricingInputReference();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The size of the denominator, e.g. 0.0001 = 1 bp. For derivatives with respect to time, the default period is 1 day.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The size of the denominator, e.g. 0.0001 = 1 bp. For derivatives with respect to time, the default period is 1 day.
	 *
	 */
	BigDecimal getScale();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A set of sensitivity definitions. Either one per point reported, or one generic definition that applies to all points.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A set of sensitivity definitions. Either one per point reported, or one generic definition that applies to all points.
	 *
	 */
	List<? extends SensitivityDefinition> getSensitivityDefinition();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The method by which each derivative is computed, e.g. analytic, numerical model, perturbation, etc., and the corresponding parameters (eg. shift amounts).
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The method by which each derivative is computed, e.g. analytic, numerical model, perturbation, etc., and the corresponding parameters (eg. shift amounts).
	 *
	 */
	DerivativeCalculationProcedure getCalculationProcedure();

	/*********************** Build Methods  ***********************/
	SensitivitySetDefinition build();
	
	SensitivitySetDefinition.SensitivitySetDefinitionBuilder toBuilder();
	
	static SensitivitySetDefinition.SensitivitySetDefinitionBuilder builder() {
		return new SensitivitySetDefinition.SensitivitySetDefinitionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends SensitivitySetDefinition> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends SensitivitySetDefinition> getType() {
		return SensitivitySetDefinition.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		processRosetta(path.newSubPath("sensitivityCharacteristics"), processor, QuotationCharacteristics.class, getSensitivityCharacteristics());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("pricingInputType"), processor, PricingInputType.class, getPricingInputType());
		processRosetta(path.newSubPath("pricingInputReference"), processor, PricingStructureReference.class, getPricingInputReference());
		processor.processBasic(path.newSubPath("scale"), BigDecimal.class, getScale(), this);
		processRosetta(path.newSubPath("sensitivityDefinition"), processor, SensitivityDefinition.class, getSensitivityDefinition());
		processRosetta(path.newSubPath("calculationProcedure"), processor, DerivativeCalculationProcedure.class, getCalculationProcedure());
	}
	

	/*********************** Builder Interface  ***********************/
	interface SensitivitySetDefinitionBuilder extends SensitivitySetDefinition, RosettaModelObjectBuilder {
		QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateSensitivityCharacteristics();
		@Override
		QuotationCharacteristics.QuotationCharacteristicsBuilder getSensitivityCharacteristics();
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference();
		@Override
		ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference();
		PricingInputType.PricingInputTypeBuilder getOrCreatePricingInputType();
		@Override
		PricingInputType.PricingInputTypeBuilder getPricingInputType();
		PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingInputReference();
		@Override
		PricingStructureReference.PricingStructureReferenceBuilder getPricingInputReference();
		SensitivityDefinition.SensitivityDefinitionBuilder getOrCreateSensitivityDefinition(int index);
		@Override
		List<? extends SensitivityDefinition.SensitivityDefinitionBuilder> getSensitivityDefinition();
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getOrCreateCalculationProcedure();
		@Override
		DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder getCalculationProcedure();
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setId(String id);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setName(String name);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setSensitivityCharacteristics(QuotationCharacteristics sensitivityCharacteristics);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setPricingInputType(PricingInputType pricingInputType);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setPricingInputReference(PricingStructureReference pricingInputReference);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setScale(BigDecimal scale);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(SensitivityDefinition sensitivityDefinition);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(SensitivityDefinition sensitivityDefinition, int idx);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(List<? extends SensitivityDefinition> sensitivityDefinition);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setSensitivityDefinition(List<? extends SensitivityDefinition> sensitivityDefinition);
		SensitivitySetDefinition.SensitivitySetDefinitionBuilder setCalculationProcedure(DerivativeCalculationProcedure calculationProcedure);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
			processRosetta(path.newSubPath("sensitivityCharacteristics"), processor, QuotationCharacteristics.QuotationCharacteristicsBuilder.class, getSensitivityCharacteristics());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("pricingInputType"), processor, PricingInputType.PricingInputTypeBuilder.class, getPricingInputType());
			processRosetta(path.newSubPath("pricingInputReference"), processor, PricingStructureReference.PricingStructureReferenceBuilder.class, getPricingInputReference());
			processor.processBasic(path.newSubPath("scale"), BigDecimal.class, getScale(), this);
			processRosetta(path.newSubPath("sensitivityDefinition"), processor, SensitivityDefinition.SensitivityDefinitionBuilder.class, getSensitivityDefinition());
			processRosetta(path.newSubPath("calculationProcedure"), processor, DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder.class, getCalculationProcedure());
		}
		

		SensitivitySetDefinition.SensitivitySetDefinitionBuilder prune();
	}

	/*********************** Immutable Implementation of SensitivitySetDefinition  ***********************/
	class SensitivitySetDefinitionImpl implements SensitivitySetDefinition {
		private final String id;
		private final String name;
		private final QuotationCharacteristics sensitivityCharacteristics;
		private final ValuationScenarioReference valuationScenarioReference;
		private final PricingInputType pricingInputType;
		private final PricingStructureReference pricingInputReference;
		private final BigDecimal scale;
		private final List<? extends SensitivityDefinition> sensitivityDefinition;
		private final DerivativeCalculationProcedure calculationProcedure;
		
		protected SensitivitySetDefinitionImpl(SensitivitySetDefinition.SensitivitySetDefinitionBuilder builder) {
			this.id = builder.getId();
			this.name = builder.getName();
			this.sensitivityCharacteristics = ofNullable(builder.getSensitivityCharacteristics()).map(f->f.build()).orElse(null);
			this.valuationScenarioReference = ofNullable(builder.getValuationScenarioReference()).map(f->f.build()).orElse(null);
			this.pricingInputType = ofNullable(builder.getPricingInputType()).map(f->f.build()).orElse(null);
			this.pricingInputReference = ofNullable(builder.getPricingInputReference()).map(f->f.build()).orElse(null);
			this.scale = builder.getScale();
			this.sensitivityDefinition = ofNullable(builder.getSensitivityDefinition()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
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
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("sensitivityCharacteristics")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sensitivityCharacteristics")
		public QuotationCharacteristics getSensitivityCharacteristics() {
			return sensitivityCharacteristics;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationScenarioReference")
		public ValuationScenarioReference getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		@RosettaAttribute("pricingInputType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingInputType")
		public PricingInputType getPricingInputType() {
			return pricingInputType;
		}
		
		@Override
		@RosettaAttribute("pricingInputReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingInputReference")
		public PricingStructureReference getPricingInputReference() {
			return pricingInputReference;
		}
		
		@Override
		@RosettaAttribute("scale")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scale")
		public BigDecimal getScale() {
			return scale;
		}
		
		@Override
		@RosettaAttribute("sensitivityDefinition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sensitivityDefinition")
		public List<? extends SensitivityDefinition> getSensitivityDefinition() {
			return sensitivityDefinition;
		}
		
		@Override
		@RosettaAttribute("calculationProcedure")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("calculationProcedure")
		public DerivativeCalculationProcedure getCalculationProcedure() {
			return calculationProcedure;
		}
		
		@Override
		public SensitivitySetDefinition build() {
			return this;
		}
		
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder toBuilder() {
			SensitivitySetDefinition.SensitivitySetDefinitionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(SensitivitySetDefinition.SensitivitySetDefinitionBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getName()).ifPresent(builder::setName);
			ofNullable(getSensitivityCharacteristics()).ifPresent(builder::setSensitivityCharacteristics);
			ofNullable(getValuationScenarioReference()).ifPresent(builder::setValuationScenarioReference);
			ofNullable(getPricingInputType()).ifPresent(builder::setPricingInputType);
			ofNullable(getPricingInputReference()).ifPresent(builder::setPricingInputReference);
			ofNullable(getScale()).ifPresent(builder::setScale);
			ofNullable(getSensitivityDefinition()).ifPresent(builder::setSensitivityDefinition);
			ofNullable(getCalculationProcedure()).ifPresent(builder::setCalculationProcedure);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivitySetDefinition _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(sensitivityCharacteristics, _that.getSensitivityCharacteristics())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(pricingInputType, _that.getPricingInputType())) return false;
			if (!Objects.equals(pricingInputReference, _that.getPricingInputReference())) return false;
			if (!Objects.equals(scale, _that.getScale())) return false;
			if (!ListEquals.listEquals(sensitivityDefinition, _that.getSensitivityDefinition())) return false;
			if (!Objects.equals(calculationProcedure, _that.getCalculationProcedure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (sensitivityCharacteristics != null ? sensitivityCharacteristics.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (pricingInputType != null ? pricingInputType.hashCode() : 0);
			_result = 31 * _result + (pricingInputReference != null ? pricingInputReference.hashCode() : 0);
			_result = 31 * _result + (scale != null ? scale.hashCode() : 0);
			_result = 31 * _result + (sensitivityDefinition != null ? sensitivityDefinition.hashCode() : 0);
			_result = 31 * _result + (calculationProcedure != null ? calculationProcedure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivitySetDefinition {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"sensitivityCharacteristics=" + this.sensitivityCharacteristics + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"pricingInputType=" + this.pricingInputType + ", " +
				"pricingInputReference=" + this.pricingInputReference + ", " +
				"scale=" + this.scale + ", " +
				"sensitivityDefinition=" + this.sensitivityDefinition + ", " +
				"calculationProcedure=" + this.calculationProcedure +
			'}';
		}
	}

	/*********************** Builder Implementation of SensitivitySetDefinition  ***********************/
	class SensitivitySetDefinitionBuilderImpl implements SensitivitySetDefinition.SensitivitySetDefinitionBuilder {
	
		protected String id;
		protected String name;
		protected QuotationCharacteristics.QuotationCharacteristicsBuilder sensitivityCharacteristics;
		protected ValuationScenarioReference.ValuationScenarioReferenceBuilder valuationScenarioReference;
		protected PricingInputType.PricingInputTypeBuilder pricingInputType;
		protected PricingStructureReference.PricingStructureReferenceBuilder pricingInputReference;
		protected BigDecimal scale;
		protected List<SensitivityDefinition.SensitivityDefinitionBuilder> sensitivityDefinition = new ArrayList<>();
		protected DerivativeCalculationProcedure.DerivativeCalculationProcedureBuilder calculationProcedure;
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("name")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("sensitivityCharacteristics")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sensitivityCharacteristics")
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getSensitivityCharacteristics() {
			return sensitivityCharacteristics;
		}
		
		@Override
		public QuotationCharacteristics.QuotationCharacteristicsBuilder getOrCreateSensitivityCharacteristics() {
			QuotationCharacteristics.QuotationCharacteristicsBuilder result;
			if (sensitivityCharacteristics!=null) {
				result = sensitivityCharacteristics;
			}
			else {
				result = sensitivityCharacteristics = QuotationCharacteristics.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationScenarioReference")
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getValuationScenarioReference() {
			return valuationScenarioReference;
		}
		
		@Override
		public ValuationScenarioReference.ValuationScenarioReferenceBuilder getOrCreateValuationScenarioReference() {
			ValuationScenarioReference.ValuationScenarioReferenceBuilder result;
			if (valuationScenarioReference!=null) {
				result = valuationScenarioReference;
			}
			else {
				result = valuationScenarioReference = ValuationScenarioReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingInputType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingInputType")
		public PricingInputType.PricingInputTypeBuilder getPricingInputType() {
			return pricingInputType;
		}
		
		@Override
		public PricingInputType.PricingInputTypeBuilder getOrCreatePricingInputType() {
			PricingInputType.PricingInputTypeBuilder result;
			if (pricingInputType!=null) {
				result = pricingInputType;
			}
			else {
				result = pricingInputType = PricingInputType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("pricingInputReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("pricingInputReference")
		public PricingStructureReference.PricingStructureReferenceBuilder getPricingInputReference() {
			return pricingInputReference;
		}
		
		@Override
		public PricingStructureReference.PricingStructureReferenceBuilder getOrCreatePricingInputReference() {
			PricingStructureReference.PricingStructureReferenceBuilder result;
			if (pricingInputReference!=null) {
				result = pricingInputReference;
			}
			else {
				result = pricingInputReference = PricingStructureReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scale")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scale")
		public BigDecimal getScale() {
			return scale;
		}
		
		@Override
		@RosettaAttribute("sensitivityDefinition")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sensitivityDefinition")
		public List<? extends SensitivityDefinition.SensitivityDefinitionBuilder> getSensitivityDefinition() {
			return sensitivityDefinition;
		}
		
		@Override
		public SensitivityDefinition.SensitivityDefinitionBuilder getOrCreateSensitivityDefinition(int index) {
			if (sensitivityDefinition==null) {
				this.sensitivityDefinition = new ArrayList<>();
			}
			return getIndex(sensitivityDefinition, index, () -> {
						SensitivityDefinition.SensitivityDefinitionBuilder newSensitivityDefinition = SensitivityDefinition.builder();
						return newSensitivityDefinition;
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
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("name")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("name")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setName(String _name) {
			this.name = _name == null ? null : _name;
			return this;
		}
		
		@RosettaAttribute("sensitivityCharacteristics")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sensitivityCharacteristics")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setSensitivityCharacteristics(QuotationCharacteristics _sensitivityCharacteristics) {
			this.sensitivityCharacteristics = _sensitivityCharacteristics == null ? null : _sensitivityCharacteristics.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingInputType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingInputType")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setPricingInputType(PricingInputType _pricingInputType) {
			this.pricingInputType = _pricingInputType == null ? null : _pricingInputType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("pricingInputReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("pricingInputReference")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setPricingInputReference(PricingStructureReference _pricingInputReference) {
			this.pricingInputReference = _pricingInputReference == null ? null : _pricingInputReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("scale")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scale")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setScale(BigDecimal _scale) {
			this.scale = _scale == null ? null : _scale;
			return this;
		}
		
		@RosettaAttribute("sensitivityDefinition")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("sensitivityDefinition")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(SensitivityDefinition _sensitivityDefinition) {
			if (_sensitivityDefinition != null) {
				this.sensitivityDefinition.add(_sensitivityDefinition.toBuilder());
			}
			return this;
		}
		
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(SensitivityDefinition _sensitivityDefinition, int idx) {
			getIndex(this.sensitivityDefinition, idx, () -> _sensitivityDefinition.toBuilder());
			return this;
		}
		
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder addSensitivityDefinition(List<? extends SensitivityDefinition> sensitivityDefinitions) {
			if (sensitivityDefinitions != null) {
				for (final SensitivityDefinition toAdd : sensitivityDefinitions) {
					this.sensitivityDefinition.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("sensitivityDefinition")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("sensitivityDefinition")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setSensitivityDefinition(List<? extends SensitivityDefinition> sensitivityDefinitions) {
			if (sensitivityDefinitions == null) {
				this.sensitivityDefinition = new ArrayList<>();
			} else {
				this.sensitivityDefinition = sensitivityDefinitions.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("calculationProcedure")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("calculationProcedure")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder setCalculationProcedure(DerivativeCalculationProcedure _calculationProcedure) {
			this.calculationProcedure = _calculationProcedure == null ? null : _calculationProcedure.toBuilder();
			return this;
		}
		
		@Override
		public SensitivitySetDefinition build() {
			return new SensitivitySetDefinition.SensitivitySetDefinitionImpl(this);
		}
		
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder prune() {
			if (sensitivityCharacteristics!=null && !sensitivityCharacteristics.prune().hasData()) sensitivityCharacteristics = null;
			if (valuationScenarioReference!=null && !valuationScenarioReference.prune().hasData()) valuationScenarioReference = null;
			if (pricingInputType!=null && !pricingInputType.prune().hasData()) pricingInputType = null;
			if (pricingInputReference!=null && !pricingInputReference.prune().hasData()) pricingInputReference = null;
			sensitivityDefinition = sensitivityDefinition.stream().filter(b->b!=null).<SensitivityDefinition.SensitivityDefinitionBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (calculationProcedure!=null && !calculationProcedure.prune().hasData()) calculationProcedure = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getName()!=null) return true;
			if (getSensitivityCharacteristics()!=null && getSensitivityCharacteristics().hasData()) return true;
			if (getValuationScenarioReference()!=null && getValuationScenarioReference().hasData()) return true;
			if (getPricingInputType()!=null && getPricingInputType().hasData()) return true;
			if (getPricingInputReference()!=null && getPricingInputReference().hasData()) return true;
			if (getScale()!=null) return true;
			if (getSensitivityDefinition()!=null && getSensitivityDefinition().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCalculationProcedure()!=null && getCalculationProcedure().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public SensitivitySetDefinition.SensitivitySetDefinitionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			SensitivitySetDefinition.SensitivitySetDefinitionBuilder o = (SensitivitySetDefinition.SensitivitySetDefinitionBuilder) other;
			
			merger.mergeRosetta(getSensitivityCharacteristics(), o.getSensitivityCharacteristics(), this::setSensitivityCharacteristics);
			merger.mergeRosetta(getValuationScenarioReference(), o.getValuationScenarioReference(), this::setValuationScenarioReference);
			merger.mergeRosetta(getPricingInputType(), o.getPricingInputType(), this::setPricingInputType);
			merger.mergeRosetta(getPricingInputReference(), o.getPricingInputReference(), this::setPricingInputReference);
			merger.mergeRosetta(getSensitivityDefinition(), o.getSensitivityDefinition(), this::getOrCreateSensitivityDefinition);
			merger.mergeRosetta(getCalculationProcedure(), o.getCalculationProcedure(), this::setCalculationProcedure);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			merger.mergeBasic(getScale(), o.getScale(), this::setScale);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			SensitivitySetDefinition _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			if (!Objects.equals(sensitivityCharacteristics, _that.getSensitivityCharacteristics())) return false;
			if (!Objects.equals(valuationScenarioReference, _that.getValuationScenarioReference())) return false;
			if (!Objects.equals(pricingInputType, _that.getPricingInputType())) return false;
			if (!Objects.equals(pricingInputReference, _that.getPricingInputReference())) return false;
			if (!Objects.equals(scale, _that.getScale())) return false;
			if (!ListEquals.listEquals(sensitivityDefinition, _that.getSensitivityDefinition())) return false;
			if (!Objects.equals(calculationProcedure, _that.getCalculationProcedure())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			_result = 31 * _result + (sensitivityCharacteristics != null ? sensitivityCharacteristics.hashCode() : 0);
			_result = 31 * _result + (valuationScenarioReference != null ? valuationScenarioReference.hashCode() : 0);
			_result = 31 * _result + (pricingInputType != null ? pricingInputType.hashCode() : 0);
			_result = 31 * _result + (pricingInputReference != null ? pricingInputReference.hashCode() : 0);
			_result = 31 * _result + (scale != null ? scale.hashCode() : 0);
			_result = 31 * _result + (sensitivityDefinition != null ? sensitivityDefinition.hashCode() : 0);
			_result = 31 * _result + (calculationProcedure != null ? calculationProcedure.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SensitivitySetDefinitionBuilder {" +
				"id=" + this.id + ", " +
				"name=" + this.name + ", " +
				"sensitivityCharacteristics=" + this.sensitivityCharacteristics + ", " +
				"valuationScenarioReference=" + this.valuationScenarioReference + ", " +
				"pricingInputType=" + this.pricingInputType + ", " +
				"pricingInputReference=" + this.pricingInputReference + ", " +
				"scale=" + this.scale + ", " +
				"sensitivityDefinition=" + this.sensitivityDefinition + ", " +
				"calculationProcedure=" + this.calculationProcedure +
			'}';
		}
	}
}
