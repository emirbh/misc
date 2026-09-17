package fpml.consolidated.mktenv;

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
import fpml.consolidated.asset.AnyAssetReference;
import fpml.consolidated.mktenv.meta.VolatilityMatrixMeta;
import fpml.consolidated.riskdef.PricingStructureValuation;
import fpml.consolidated.riskdef.ValuationScenarioReference;
import fpml.consolidated.shared.IdentifiedDate;
import java.time.ZonedDateTime;
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
 * Provision A matrix of volatilities with dimension 0-3.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A matrix of volatilities with dimension 0-3.
 *
 */
@RosettaDataType(value="VolatilityMatrix", builder=VolatilityMatrix.VolatilityMatrixBuilderImpl.class, version="2.1.1")
@RuneDataType(value="VolatilityMatrix", model="fpml", builder=VolatilityMatrix.VolatilityMatrixBuilderImpl.class, version="2.1.1")
public interface VolatilityMatrix extends PricingStructureValuation {

	VolatilityMatrixMeta metaData = new VolatilityMatrixMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The raw volatility matrix data, expressed as a multi-dimensional array.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The raw volatility matrix data, expressed as a multi-dimensional array.
	 *
	 */
	MultiDimensionalPricingData getDataPoints();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An adjustment factor, such as for vol smile/skew.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An adjustment factor, such as for vol smile/skew.
	 *
	 */
	List<? extends ParametricAdjustment> getAdjustment();

	/*********************** Build Methods  ***********************/
	VolatilityMatrix build();
	
	VolatilityMatrix.VolatilityMatrixBuilder toBuilder();
	
	static VolatilityMatrix.VolatilityMatrixBuilder builder() {
		return new VolatilityMatrix.VolatilityMatrixBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends VolatilityMatrix> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends VolatilityMatrix> getType() {
		return VolatilityMatrix.class;
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
	interface VolatilityMatrixBuilder extends VolatilityMatrix, PricingStructureValuation.PricingStructureValuationBuilder {
		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder getOrCreateDataPoints();
		@Override
		MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder getDataPoints();
		ParametricAdjustment.ParametricAdjustmentBuilder getOrCreateAdjustment(int index);
		@Override
		List<? extends ParametricAdjustment.ParametricAdjustmentBuilder> getAdjustment();
		@Override
		VolatilityMatrix.VolatilityMatrixBuilder setId(String id);
		@Override
		VolatilityMatrix.VolatilityMatrixBuilder setDefinitionRef(String definitionRef);
		@Override
		VolatilityMatrix.VolatilityMatrixBuilder setObjectReference(AnyAssetReference objectReference);
		@Override
		VolatilityMatrix.VolatilityMatrixBuilder setValuationScenarioReference(ValuationScenarioReference valuationScenarioReference);
		@Override
		VolatilityMatrix.VolatilityMatrixBuilder setBaseDate(IdentifiedDate baseDate);
		@Override
		VolatilityMatrix.VolatilityMatrixBuilder setSpotDate(IdentifiedDate spotDate);
		@Override
		VolatilityMatrix.VolatilityMatrixBuilder setInputDataDate(IdentifiedDate inputDataDate);
		@Override
		VolatilityMatrix.VolatilityMatrixBuilder setEndDate(IdentifiedDate endDate);
		@Override
		VolatilityMatrix.VolatilityMatrixBuilder setBuildDateTime(ZonedDateTime buildDateTime);
		VolatilityMatrix.VolatilityMatrixBuilder setDataPoints(MultiDimensionalPricingData dataPoints);
		VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(ParametricAdjustment adjustment);
		VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(ParametricAdjustment adjustment, int idx);
		VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(List<? extends ParametricAdjustment> adjustment);
		VolatilityMatrix.VolatilityMatrixBuilder setAdjustment(List<? extends ParametricAdjustment> adjustment);

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
		

		VolatilityMatrix.VolatilityMatrixBuilder prune();
	}

	/*********************** Immutable Implementation of VolatilityMatrix  ***********************/
	class VolatilityMatrixImpl extends PricingStructureValuation.PricingStructureValuationImpl implements VolatilityMatrix {
		private final MultiDimensionalPricingData dataPoints;
		private final List<? extends ParametricAdjustment> adjustment;
		
		protected VolatilityMatrixImpl(VolatilityMatrix.VolatilityMatrixBuilder builder) {
			super(builder);
			this.dataPoints = ofNullable(builder.getDataPoints()).map(f->f.build()).orElse(null);
			this.adjustment = ofNullable(builder.getAdjustment()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("dataPoints")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dataPoints")
		public MultiDimensionalPricingData getDataPoints() {
			return dataPoints;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("adjustment")
		public List<? extends ParametricAdjustment> getAdjustment() {
			return adjustment;
		}
		
		@Override
		public VolatilityMatrix build() {
			return this;
		}
		
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder toBuilder() {
			VolatilityMatrix.VolatilityMatrixBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(VolatilityMatrix.VolatilityMatrixBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getDataPoints()).ifPresent(builder::setDataPoints);
			ofNullable(getAdjustment()).ifPresent(builder::setAdjustment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(dataPoints, _that.getDataPoints())) return false;
			if (!ListEquals.listEquals(adjustment, _that.getAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dataPoints != null ? dataPoints.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityMatrix {" +
				"dataPoints=" + this.dataPoints + ", " +
				"adjustment=" + this.adjustment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of VolatilityMatrix  ***********************/
	class VolatilityMatrixBuilderImpl extends PricingStructureValuation.PricingStructureValuationBuilderImpl implements VolatilityMatrix.VolatilityMatrixBuilder {
	
		protected MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder dataPoints;
		protected List<ParametricAdjustment.ParametricAdjustmentBuilder> adjustment = new ArrayList<>();
		
		@Override
		@RosettaAttribute("dataPoints")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dataPoints")
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder getDataPoints() {
			return dataPoints;
		}
		
		@Override
		public MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder getOrCreateDataPoints() {
			MultiDimensionalPricingData.MultiDimensionalPricingDataBuilder result;
			if (dataPoints!=null) {
				result = dataPoints;
			}
			else {
				result = dataPoints = MultiDimensionalPricingData.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("adjustment")
		public List<? extends ParametricAdjustment.ParametricAdjustmentBuilder> getAdjustment() {
			return adjustment;
		}
		
		@Override
		public ParametricAdjustment.ParametricAdjustmentBuilder getOrCreateAdjustment(int index) {
			if (adjustment==null) {
				this.adjustment = new ArrayList<>();
			}
			return getIndex(adjustment, index, () -> {
						ParametricAdjustment.ParametricAdjustmentBuilder newAdjustment = ParametricAdjustment.builder();
						return newAdjustment;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("definitionRef")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("definitionRef")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setDefinitionRef(String _definitionRef) {
			this.definitionRef = _definitionRef == null ? null : _definitionRef;
			return this;
		}
		
		@RosettaAttribute("objectReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("objectReference")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setObjectReference(AnyAssetReference _objectReference) {
			this.objectReference = _objectReference == null ? null : _objectReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("valuationScenarioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationScenarioReference")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setValuationScenarioReference(ValuationScenarioReference _valuationScenarioReference) {
			this.valuationScenarioReference = _valuationScenarioReference == null ? null : _valuationScenarioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("baseDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("baseDate")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setBaseDate(IdentifiedDate _baseDate) {
			this.baseDate = _baseDate == null ? null : _baseDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("spotDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("spotDate")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setSpotDate(IdentifiedDate _spotDate) {
			this.spotDate = _spotDate == null ? null : _spotDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inputDataDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inputDataDate")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setInputDataDate(IdentifiedDate _inputDataDate) {
			this.inputDataDate = _inputDataDate == null ? null : _inputDataDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setEndDate(IdentifiedDate _endDate) {
			this.endDate = _endDate == null ? null : _endDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("buildDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("buildDateTime")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setBuildDateTime(ZonedDateTime _buildDateTime) {
			this.buildDateTime = _buildDateTime == null ? null : _buildDateTime;
			return this;
		}
		
		@RosettaAttribute("dataPoints")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dataPoints")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder setDataPoints(MultiDimensionalPricingData _dataPoints) {
			this.dataPoints = _dataPoints == null ? null : _dataPoints.toBuilder();
			return this;
		}
		
		@RosettaAttribute("adjustment")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("adjustment")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(ParametricAdjustment _adjustment) {
			if (_adjustment != null) {
				this.adjustment.add(_adjustment.toBuilder());
			}
			return this;
		}
		
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(ParametricAdjustment _adjustment, int idx) {
			getIndex(this.adjustment, idx, () -> _adjustment.toBuilder());
			return this;
		}
		
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder addAdjustment(List<? extends ParametricAdjustment> adjustments) {
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
		public VolatilityMatrix.VolatilityMatrixBuilder setAdjustment(List<? extends ParametricAdjustment> adjustments) {
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
		public VolatilityMatrix build() {
			return new VolatilityMatrix.VolatilityMatrixImpl(this);
		}
		
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder prune() {
			super.prune();
			if (dataPoints!=null && !dataPoints.prune().hasData()) dataPoints = null;
			adjustment = adjustment.stream().filter(b->b!=null).<ParametricAdjustment.ParametricAdjustmentBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getDataPoints()!=null && getDataPoints().hasData()) return true;
			if (getAdjustment()!=null && getAdjustment().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public VolatilityMatrix.VolatilityMatrixBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			VolatilityMatrix.VolatilityMatrixBuilder o = (VolatilityMatrix.VolatilityMatrixBuilder) other;
			
			merger.mergeRosetta(getDataPoints(), o.getDataPoints(), this::setDataPoints);
			merger.mergeRosetta(getAdjustment(), o.getAdjustment(), this::getOrCreateAdjustment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			VolatilityMatrix _that = getType().cast(o);
		
			if (!Objects.equals(dataPoints, _that.getDataPoints())) return false;
			if (!ListEquals.listEquals(adjustment, _that.getAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (dataPoints != null ? dataPoints.hashCode() : 0);
			_result = 31 * _result + (adjustment != null ? adjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "VolatilityMatrixBuilder {" +
				"dataPoints=" + this.dataPoints + ", " +
				"adjustment=" + this.adjustment +
			'}' + " " + super.toString();
		}
	}
}
