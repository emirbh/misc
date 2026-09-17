package cdm.product.collateral;

import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.product.collateral.meta.EligibleCollateralCriteriaMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RosettaIgnore;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneIgnore;
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
 * Represents a set of criteria used to specify eligible collateral.
 * @version 6.23.0
 */
@RosettaDataType(value="EligibleCollateralCriteria", builder=EligibleCollateralCriteria.EligibleCollateralCriteriaBuilderImpl.class, version="6.23.0")
@RuneDataType(value="EligibleCollateralCriteria", model="cdm", builder=EligibleCollateralCriteria.EligibleCollateralCriteriaBuilderImpl.class, version="6.23.0")
public interface EligibleCollateralCriteria extends CollateralCriteriaBase {

	EligibleCollateralCriteriaMeta metaData = new EligibleCollateralCriteriaMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The specific criteria in an Eligible Collateral Schedule. This is a mandatory attribute of an ECS so an override is required to enforce the cardinality.
	 */
	@Override
	CollateralCriteria getCollateralCriteria();
	/**
	 * Identifies the treatment of specified collateral, e.g., haircuts,holding limits or exclusions.
	 */
	CollateralTreatment getTreatment();

	/*********************** Build Methods  ***********************/
	EligibleCollateralCriteria build();
	
	EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder toBuilder();
	
	static EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder() {
		return new EligibleCollateralCriteria.EligibleCollateralCriteriaBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends EligibleCollateralCriteria> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends EligibleCollateralCriteria> getType() {
		return EligibleCollateralCriteria.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralCriteria"), processor, CollateralCriteria.class, getCollateralCriteria());
		processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
		processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
		processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
		processRosetta(path.newSubPath("treatment"), processor, CollateralTreatment.class, getTreatment());
	}
	

	/*********************** Builder Interface  ***********************/
	interface EligibleCollateralCriteriaBuilder extends EligibleCollateralCriteria, CollateralCriteriaBase.CollateralCriteriaBaseBuilder {
		CollateralCriteria.CollateralCriteriaBuilder getOrCreateCollateralCriteria();
		@Override
		CollateralCriteria.CollateralCriteriaBuilder getCollateralCriteria();
		CollateralTreatment.CollateralTreatmentBuilder getOrCreateTreatment();
		@Override
		CollateralTreatment.CollateralTreatmentBuilder getTreatment();
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setCollateralCriteria(CollateralCriteria collateralCriteria);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(CounterpartyRoleEnum appliesTo);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(CounterpartyRoleEnum appliesTo, int idx);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTo);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTo);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setRestrictTo(CollateralMarginTypeEnum restrictTo);
		@Override
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum ratingPriorityResolution);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setCollateralCriteriaOverriddenAsCollateralCriteria(CollateralCriteria collateralCriteria);
		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setTreatment(CollateralTreatment treatment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralCriteria"), processor, CollateralCriteria.CollateralCriteriaBuilder.class, getCollateralCriteria());
			processor.processBasic(path.newSubPath("appliesTo"), CounterpartyRoleEnum.class, getAppliesTo(), this);
			processor.processBasic(path.newSubPath("restrictTo"), CollateralMarginTypeEnum.class, getRestrictTo(), this);
			processor.processBasic(path.newSubPath("ratingPriorityResolution"), RatingPriorityResolutionEnum.class, getRatingPriorityResolution(), this);
			processRosetta(path.newSubPath("treatment"), processor, CollateralTreatment.CollateralTreatmentBuilder.class, getTreatment());
		}
		

		EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder prune();
	}

	/*********************** Immutable Implementation of EligibleCollateralCriteria  ***********************/
	class EligibleCollateralCriteriaImpl extends CollateralCriteriaBase.CollateralCriteriaBaseImpl implements EligibleCollateralCriteria {
		private final CollateralCriteria collateralCriteria;
		private final CollateralTreatment treatment;
		
		protected EligibleCollateralCriteriaImpl(EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder) {
			super(builder);
			this.collateralCriteria = ofNullable(builder.getCollateralCriteria()).map(f->f.build()).orElse(null);
			this.treatment = ofNullable(builder.getTreatment()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("collateralCriteria")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralCriteria")
		public CollateralCriteria getCollateralCriteria() {
			return collateralCriteria;
		}
		
		@Override
		@RosettaAttribute("treatment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("treatment")
		public CollateralTreatment getTreatment() {
			return treatment;
		}
		
		@Override
		public EligibleCollateralCriteria build() {
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder toBuilder() {
			EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCollateralCriteria()).ifPresent(builder::setCollateralCriteriaOverriddenAsCollateralCriteria);
			ofNullable(getTreatment()).ifPresent(builder::setTreatment);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EligibleCollateralCriteria _that = getType().cast(o);
		
			if (!Objects.equals(collateralCriteria, _that.getCollateralCriteria())) return false;
			if (!Objects.equals(treatment, _that.getTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (collateralCriteria != null ? collateralCriteria.hashCode() : 0);
			_result = 31 * _result + (treatment != null ? treatment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralCriteria {" +
				"collateralCriteria=" + this.collateralCriteria + ", " +
				"treatment=" + this.treatment +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of EligibleCollateralCriteria  ***********************/
	class EligibleCollateralCriteriaBuilderImpl extends CollateralCriteriaBase.CollateralCriteriaBaseBuilderImpl implements EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder {
	
		protected CollateralCriteria.CollateralCriteriaBuilder collateralCriteria;
		protected CollateralTreatment.CollateralTreatmentBuilder treatment;
		
		@Override
		@RosettaAttribute("collateralCriteria")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collateralCriteria")
		public CollateralCriteria.CollateralCriteriaBuilder getCollateralCriteria() {
			return collateralCriteria;
		}
		
		@Override
		public CollateralCriteria.CollateralCriteriaBuilder getOrCreateCollateralCriteria() {
			CollateralCriteria.CollateralCriteriaBuilder result;
			if (collateralCriteria!=null) {
				result = collateralCriteria;
			}
			else {
				result = collateralCriteria = CollateralCriteria.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("treatment")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("treatment")
		public CollateralTreatment.CollateralTreatmentBuilder getTreatment() {
			return treatment;
		}
		
		@Override
		public CollateralTreatment.CollateralTreatmentBuilder getOrCreateTreatment() {
			CollateralTreatment.CollateralTreatmentBuilder result;
			if (treatment!=null) {
				result = treatment;
			}
			else {
				result = treatment = CollateralTreatment.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("collateralCriteria")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collateralCriteria")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setCollateralCriteriaOverriddenAsCollateralCriteria(CollateralCriteria _collateralCriteria) {
			this.collateralCriteria = _collateralCriteria == null ? null : _collateralCriteria.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setCollateralCriteria(CollateralCriteria _collateralCriteria) {
			return setCollateralCriteriaOverriddenAsCollateralCriteria(_collateralCriteria);
		}
		
		@RosettaAttribute("appliesTo")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("appliesTo")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(CounterpartyRoleEnum _appliesTo) {
			if (_appliesTo != null) {
				this.appliesTo.add(_appliesTo);
			}
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(CounterpartyRoleEnum _appliesTo, int idx) {
			getIndex(this.appliesTo, idx, () -> _appliesTo);
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder addAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
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
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setAppliesTo(List<CounterpartyRoleEnum> appliesTos) {
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
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setRestrictTo(CollateralMarginTypeEnum _restrictTo) {
			this.restrictTo = _restrictTo == null ? null : _restrictTo;
			return this;
		}
		
		@RosettaAttribute("ratingPriorityResolution")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ratingPriorityResolution")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setRatingPriorityResolution(RatingPriorityResolutionEnum _ratingPriorityResolution) {
			this.ratingPriorityResolution = _ratingPriorityResolution == null ? null : _ratingPriorityResolution;
			return this;
		}
		
		@RosettaAttribute("treatment")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("treatment")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder setTreatment(CollateralTreatment _treatment) {
			this.treatment = _treatment == null ? null : _treatment.toBuilder();
			return this;
		}
		
		@Override
		public EligibleCollateralCriteria build() {
			return new EligibleCollateralCriteria.EligibleCollateralCriteriaImpl(this);
		}
		
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder prune() {
			super.prune();
			if (collateralCriteria!=null && !collateralCriteria.prune().hasData()) collateralCriteria = null;
			if (treatment!=null && !treatment.prune().hasData()) treatment = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCollateralCriteria()!=null && getCollateralCriteria().hasData()) return true;
			if (getTreatment()!=null && getTreatment().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder o = (EligibleCollateralCriteria.EligibleCollateralCriteriaBuilder) other;
			
			merger.mergeRosetta(getCollateralCriteria(), o.getCollateralCriteria(), this::setCollateralCriteriaOverriddenAsCollateralCriteria);
			merger.mergeRosetta(getTreatment(), o.getTreatment(), this::setTreatment);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			EligibleCollateralCriteria _that = getType().cast(o);
		
			if (!Objects.equals(collateralCriteria, _that.getCollateralCriteria())) return false;
			if (!Objects.equals(treatment, _that.getTreatment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (collateralCriteria != null ? collateralCriteria.hashCode() : 0);
			_result = 31 * _result + (treatment != null ? treatment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "EligibleCollateralCriteriaBuilder {" +
				"collateralCriteria=" + this.collateralCriteria + ", " +
				"treatment=" + this.treatment +
			'}' + " " + super.toString();
		}
	}
}
