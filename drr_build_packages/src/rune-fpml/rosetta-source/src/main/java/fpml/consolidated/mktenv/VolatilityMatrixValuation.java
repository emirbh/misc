package fpml.consolidated.mktenv;

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
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.mktenv.meta.VolatilityMatrixValuationMeta;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @version 2.1.1
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
@RosettaDataType(value="VolatilityMatrixValuation", builder=VolatilityMatrixValuation.VolatilityMatrixValuationBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VolatilityMatrixValuation", model="fpml", builder=VolatilityMatrixValuation.VolatilityMatrixValuationBuilderImpl.class, version="2.1.1")
public interface VolatilityMatrixValuation extends VolatilityMatrix {

	VolatilityMatrixValuationMeta metaData = new VolatilityMatrixValuationMeta();

	/*********************** Getter Methods  ***********************/

	/*********************** Build Methods  ***********************/
	VolatilityMatrixValuation build();
	
	VolatilityMatrixValuation.VolatilityMatrixValuationBuilder toBuilder();
	
	static VolatilityMatrixValuation.VolatilityMatrixValuationBuilder builder() {
		return new VolatilityMatrixValuation.VolatilityMatrixValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityMatrixValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VolatilityMatrixValuation> getType() {
		return VolatilityMatrixValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
		processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.class, getObjectReference());
		processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.class, getValuationScenarioReference());
		processRosetta(path.newSubPath("baseDate"), processor, IdentifiedDate.class, getBaseDate());
		processRosetta(path.newSubPath("spotDate"), processor, IdentifiedDate.class, getSpotDate());
		processRosetta(path.newSubPath("inputDataDate"), processor, IdentifiedDate.class, getInputDataDate());
		processRosetta(path.newSubPath("endDate"), processor, IdentifiedDate.class, getEndDate());
		processor.processBasic(path.newSubPath("buildDateTime"), ZonedDateTime.class, getBuildDateTime(), this);
		processRosetta(path.newSubPath("dataPoints"), processor, MultiDimensionalPricingData.class, getDataPoints());
		processRosetta(path.newSubPath("adjustment"), processor, ParametricAdjustment.class, getAdjustment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface VolatilityMatrixValuationBuilder extends VolatilityMatrixValuation, VolatilityMatrix.VolatilityMatrixBuilder {
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setId(String id);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setDefinitionRef(String definitionRef);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setObjectReference(AnyAssetReference objectReference);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setBaseDate(IdentifiedDate baseDate);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setSpotDate(IdentifiedDate spotDate);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setInputDataDate(IdentifiedDate inputDataDate);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setEndDate(IdentifiedDate endDate);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setBuildDateTime(ZonedDateTime buildDateTime);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setDataPoints(MultiDimensionalPricingData dataPoints);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(ParametricAdjustment adjustment);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(ParametricAdjustment adjustment, int idx);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(List<? extends ParametricAdjustment> adjustment);
		@Override
		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setAdjustment(List<? extends ParametricAdjustment> adjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("definitionRef"), String.class, getDefinitionRef(), this);
			processRosetta(path.newSubPath("objectReference"), processor, AnyAssetReference.AnyAssetReferenceBuilder.class, getObjectReference());
			processRosetta(path.newSubPath("valuationScenarioReference"), processor, ValuationScenarioReference.ValuationScenarioReferenceBuilder.class, getValuationScenarioReference());
			processRosetta(path.newSubPath("baseDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getBaseDate());
			processRosetta(path.newSubPath("spotDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getSpotDate());
			processRosetta(path.newSubPath("inputDataDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getInputDataDate());
			processRosetta(path.newSubPath("endDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getEndDate());
			processor.processBasic(path.newSubPath("buildDateTime"), ZonedDateTime.class, getBuildDateTime(), this);
			processRosetta(path.newSubPath("dataPoints"), processor, MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder.class, getDataPoints());
			processRosetta(path.newSubPath("adjustment"), processor, ParametricAdjustment.ParametricAdjustmentBuilder.class, getAdjustment());
		}
		

		VolatilityMatrixValuation.VolatilityMatrixValuationBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityMatrixValuation  ***********************/
	class VolatilityMatrixValuationImpl extends VolatilityMatrix.VolatilityMatrixImpl implements VolatilityMatrixValuation {
		
		protected VolatilityMatrixValuationImpl(VolatilityMatrixValuation.VolatilityMatrixValuationBuilder builder) {
			super(builder);
		}
		
		@Override
		public VolatilityMatrixValuation build() {
			return this;
		}
		
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder toBuilder() {
			VolatilityMatrixValuation.VolatilityMatrixValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityMatrixValuation.VolatilityMatrixValuationBuilder builder) {
			super.setBuilderFields(builder);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityMatrixValuation {" +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityMatrixValuation  ***********************/
	class VolatilityMatrixValuationBuilderImpl extends VolatilityMatrix.VolatilityMatrixBuilderImpl implements VolatilityMatrixValuation.VolatilityMatrixValuationBuilder {
	
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("baseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseDate")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setBaseDate(IdentifiedDate _baseDate) {
			this.baseDate = _baseDate == null ? null : _baseDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotDate")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setSpotDate(IdentifiedDate _spotDate) {
			this.spotDate = _spotDate == null ? null : _spotDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inputDataDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inputDataDate")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setInputDataDate(IdentifiedDate _inputDataDate) {
			this.inputDataDate = _inputDataDate == null ? null : _inputDataDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setEndDate(IdentifiedDate _endDate) {
			this.endDate = _endDate == null ? null : _endDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buildDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buildDateTime")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setBuildDateTime(ZonedDateTime _buildDateTime) {
			this.buildDateTime = _buildDateTime == null ? null : _buildDateTime;
			return this;
		}
		
		@RosettaAttribute("dataPoints")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dataPoints")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setDataPoints(MultiDimensionalPricingData _dataPoints) {
			this.dataPoints = _dataPoints == null ? null : _dataPoints.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("adjustment")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(ParametricAdjustment _adjustment) {
			if (_adjustment != null) {
				this.adjustment.add(_adjustment.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(ParametricAdjustment _adjustment, int idx) {
			getIndex(this.adjustment, idx, () -> _adjustment.toBuilder());
			return this;
		}
		
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder addAdjustment(List<? extends ParametricAdjustment> adjustments) {
			if (adjustments != null) {
				for (final ParametricAdjustment toAdd : adjustments) {
					this.adjustment.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("adjustment")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder setAdjustment(List<? extends ParametricAdjustment> adjustments) {
			if (adjustments == null) {
				this.adjustment = new ArrayList<>();
			} else {
				this.adjustment = adjustments.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public VolatilityMatrixValuation build() {
			return new VolatilityMatrixValuation.VolatilityMatrixValuationImpl(this);
		}
		
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityMatrixValuation.VolatilityMatrixValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VolatilityMatrixValuation.VolatilityMatrixValuationBuilder o = (VolatilityMatrixValuation.VolatilityMatrixValuationBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityMatrixValuationBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
