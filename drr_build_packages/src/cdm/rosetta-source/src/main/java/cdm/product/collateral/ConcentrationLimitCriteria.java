package cdm.product.collateral;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.collateral.meta.ConcentrationLimitCriteriaMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Respresents a class to describe a set of criteria to describe specific assets that the concentration limits apply to.
 * @version 6.23.0
 */
@RosettaDataType(value="ConcentrationLimitCriteria", builder=ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilderImpl.class, version="6.23.0")
@RuneDataType(value="ConcentrationLimitCriteria", model="cdm", builder=ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilderImpl.class, version="6.23.0")
public interface ConcentrationLimitCriteria extends CollateralCriteriaBase {

	ConcentrationLimitCriteriaMeta metaData = new ConcentrationLimitCriteriaMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the type of concentration limit to be applied.
	 */
	ConcentrationLimitTypeEnum getConcentrationLimitType();
	/**
	 * Specifies an average trading volume on an exchange in relation to Equity products.
	 */
	AverageTradingVolume getAverageTradingVolume();

	/*********************** Build Methods  ***********************/
	ConcentrationLimitCriteria build();
	
	ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder toBuilder();
	
	static ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder builder() {
		return new ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ConcentrationLimitCriteria> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ConcentrationLimitCriteria> getType() {
		return ConcentrationLimitCriteria.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralCriteria"), processor, CollateralCriteria.class, getCollateralCriteria());
		processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
		processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
		processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
		processor.processBasic(path.newSubPath("concentrationLimitType"), ConcentrationLimitTypeEnum.class, getConcentrationLimitType(), this);
		processRosetta(path.newSubPath("averageTradingVolume"), processor, AverageTradingVolume.class, getAverageTradingVolume());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ConcentrationLimitCriteriaBuilder extends ConcentrationLimitCriteria, CollateralCriteriaBase.CollateralCriteriaBaseBuilder {
		AverageTradingVolume.AverageTradingVolumeBuilder getOrCreateAverageTradingVolume();
		@Override
		AverageTradingVolume.AverageTradingVolumeBuilder getAverageTradingVolume();
		@Override
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setCollateralCriteria(CollateralCriteria collateralCriteria);
		@Override
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAppliesTo(CounterpartyRoleEnum appliesTo);
		@Override
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAppliesTo(CounterpartyRoleEnum appliesTo, int idx);
		@Override
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTo);
		@Override
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTo);
		@Override
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setRestrictTo(CollateralMarginTypeEnum restrictTo);
		@Override
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum ratingPriorityResolution);
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setConcentrationLimitType(ConcentrationLimitTypeEnum concentrationLimitType);
		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setAverageTradingVolume(AverageTradingVolume averageTradingVolume);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralCriteria"), processor, CollateralCriteria.CollateralCriteriaBuilder.class, getCollateralCriteria());
			processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
			processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
			processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
			processor.processBasic(path.newSubPath("concentrationLimitType"), ConcentrationLimitTypeEnum.class, getConcentrationLimitType(), this);
			processRosetta(path.newSubPath("averageTradingVolume"), processor, AverageTradingVolume.AverageTradingVolumeBuilder.class, getAverageTradingVolume());
		}
		

		ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder prune();
	}

	/*********************** Immutable Implementation of ConcentrationLimitCriteria  ***********************/
	class ConcentrationLimitCriteriaImpl extends CollateralCriteriaBase.CollateralCriteriaBaseImpl implements ConcentrationLimitCriteria {
		private final ConcentrationLimitTypeEnum concentrationLimitType;
		private final AverageTradingVolume averageTradingVolume;
		
		protected ConcentrationLimitCriteriaImpl(ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder builder) {
			super(builder);
			this.concentrationLimitType = builder.getConcentrationLimitType();
			this.averageTradingVolume = ofNullable(builder.getAverageTradingVolume()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("concentrationLimitType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("concentrationLimitType")
		public ConcentrationLimitTypeEnum getConcentrationLimitType() {
			return concentrationLimitType;
		}
		
		@Override
		@RosettaAttribute("averageTradingVolume")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageTradingVolume")
		public AverageTradingVolume getAverageTradingVolume() {
			return averageTradingVolume;
		}
		
		@Override
		public ConcentrationLimitCriteria build() {
			return this;
		}
		
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder toBuilder() {
			ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getConcentrationLimitType()).ifPresent(builder::setConcentrationLimitType);
			ofNullable(getAverageTradingVolume()).ifPresent(builder::setAverageTradingVolume);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConcentrationLimitCriteria _that = getType().cast(o);
		
			if (!Objects.equals(concentrationLimitType, _that.getConcentrationLimitType())) return false;
			if (!Objects.equals(averageTradingVolume, _that.getAverageTradingVolume())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (concentrationLimitType != null ? concentrationLimitType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (averageTradingVolume != null ? averageTradingVolume.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConcentrationLimitCriteria {" +
				"concentrationLimitType=" + this.concentrationLimitType + ", " +
				"averageTradingVolume=" + this.averageTradingVolume +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ConcentrationLimitCriteria  ***********************/
	class ConcentrationLimitCriteriaBuilderImpl extends CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl implements ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder {
	
		protected ConcentrationLimitTypeEnum concentrationLimitType;
		protected AverageTradingVolume.AverageTradingVolumeBuilder averageTradingVolume;
		
		@Override
		@RosettaAttribute("concentrationLimitType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("concentrationLimitType")
		public ConcentrationLimitTypeEnum getConcentrationLimitType() {
			return concentrationLimitType;
		}
		
		@Override
		@RosettaAttribute("averageTradingVolume")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("averageTradingVolume")
		public AverageTradingVolume.AverageTradingVolumeBuilder getAverageTradingVolume() {
			return averageTradingVolume;
		}
		
		@Override
		public AverageTradingVolume.AverageTradingVolumeBuilder getOrCreateAverageTradingVolume() {
			AverageTradingVolume.AverageTradingVolumeBuilder result;
			if (averageTradingVolume!=null) {
				result = averageTradingVolume;
			}
			else {
				result = averageTradingVolume = AverageTradingVolume.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("collateralCriteria")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralCriteria")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setCollateralCriteria(CollateralCriteria _collateralCriteria) {
			this.collateralCriteria = _collateralCriteria == null ? null : _collateralCriteria.toBuilder();
			return this;
		}
		
		@RosettaAttribute("appliesTo")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("appliesTo")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAppliesTo(CounterpartyRoleEnum _appliesTo) {
			if (_appliesTo != null) {
				this.appliesTo.add(_appliesTo);
			}
			return this;
		}
		
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAppliesTo(CounterpartyRoleEnum _appliesTo, int idx) {
			getIndex(this.appliesTo, idx, () -> _appliesTo);
			return this;
		}
		
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
			if (appliesTos != null) {
				for (final CounterpartyRoleEnum toAdd : appliesTos) {
					this.appliesTo.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("appliesTo")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("appliesTo")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
			if (appliesTos == null) {
				this.appliesTo = new ArrayList<>();
			} else {
				this.appliesTo = appliesTos.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("restrictTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("restrictTo")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setRestrictTo(CollateralMarginTypeEnum _restrictTo) {
			this.restrictTo = _restrictTo == null ? null : _restrictTo;
			return this;
		}
		
		@RosettaAttribute("ratingPriorityResolution")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ratingPriorityResolution")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum _ratingPriorityResolution) {
			this.ratingPriorityResolution = _ratingPriorityResolution == null ? null : _ratingPriorityResolution;
			return this;
		}
		
		@RosettaAttribute("concentrationLimitType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("concentrationLimitType")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setConcentrationLimitType(ConcentrationLimitTypeEnum _concentrationLimitType) {
			this.concentrationLimitType = _concentrationLimitType == null ? null : _concentrationLimitType;
			return this;
		}
		
		@RosettaAttribute("averageTradingVolume")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("averageTradingVolume")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder setAverageTradingVolume(AverageTradingVolume _averageTradingVolume) {
			this.averageTradingVolume = _averageTradingVolume == null ? null : _averageTradingVolume.toBuilder();
			return this;
		}
		
		@Override
		public ConcentrationLimitCriteria build() {
			return new ConcentrationLimitCriteria.ConcentrationLimitCriteriaImpl(this);
		}
		
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder prune() {
			super.prune();
			if (averageTradingVolume!=null && !averageTradingVolume.prune().hasData()) averageTradingVolume = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getConcentrationLimitType()!=null) return true;
			if (getAverageTradingVolume()!=null && getAverageTradingVolume().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder o = (ConcentrationLimitCriteria.ConcentrationLimitCriteriaBuilder) other;
			
			merger.mergeRosetta(getAverageTradingVolume(), o.getAverageTradingVolume(), this::setAverageTradingVolume);
			
			merger.mergeBasic(getConcentrationLimitType(), o.getConcentrationLimitType(), this::setConcentrationLimitType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ConcentrationLimitCriteria _that = getType().cast(o);
		
			if (!Objects.equals(concentrationLimitType, _that.getConcentrationLimitType())) return false;
			if (!Objects.equals(averageTradingVolume, _that.getAverageTradingVolume())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (concentrationLimitType != null ? concentrationLimitType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (averageTradingVolume != null ? averageTradingVolume.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ConcentrationLimitCriteriaBuilder {" +
				"concentrationLimitType=" + this.concentrationLimitType + ", " +
				"averageTradingVolume=" + this.averageTradingVolume +
			'}' + " " + super.toString();
		}
	}
}
