package cdm.observable.asset.fro;

import cdm.base.datetime.BusinessCenterEnum;
import cdm.base.datetime.BusinessCenters;
import cdm.base.datetime.daycount.DayCountFractionEnum;
import cdm.observable.asset.fro.meta.FloatingRateIndexCalculationDefaultsMeta;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * This holds the rate calculation defaults applicable for a floating rate index.
 * @version 6.23.0
 */
@RosettaDataType(value="FloatingRateIndexCalculationDefaults", builder=FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilderImpl.class, version="6.23.0")
@RuneDataType(value="FloatingRateIndexCalculationDefaults", model="cdm", builder=FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilderImpl.class, version="6.23.0")
public interface FloatingRateIndexCalculationDefaults extends RosettaModelObject {

	FloatingRateIndexCalculationDefaultsMeta metaData = new FloatingRateIndexCalculationDefaultsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The ISDA FRO category (e.g. screen rate or calculated rate).
	 */
	FloatingRateIndexCategoryEnum getCategory();
	/**
	 * The ISDA FRO style (e.g. term rate, swap rate, etc).
	 */
	FloatingRateIndexStyleEnum getIndexStyle();
	/**
	 * The ISDA FRO calculation method (e.g. OIS Compounding).
	 */
	FloatingRateIndexCalculationMethodEnum getMethod();
	/**
	 * The default fixing details.
	 */
	List<? extends FloatingRateIndexFixingDetails> getFixing();
	/**
	 * The default day count fraction.
	 */
	DayCountFractionEnum getDayCountFraction();
	/**
	 * The default applicable business days.
	 */
	BusinessCenters getApplicableBusinessDays();
	/**
	 * Publication Calendar (e.g. EUR-ICESWAP)
	 */
	BusinessCenterEnum getPublicationCalendar();

	/*********************** Build Methods  ***********************/
	FloatingRateIndexCalculationDefaults build();
	
	FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder toBuilder();
	
	static FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder builder() {
		return new FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FloatingRateIndexCalculationDefaults> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends FloatingRateIndexCalculationDefaults> getType() {
		return FloatingRateIndexCalculationDefaults.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("category"), FloatingRateIndexCategoryEnum.class, getCategory(), this);
		processor.processBasic(path.newSubPath("indexStyle"), FloatingRateIndexStyleEnum.class, getIndexStyle(), this);
		processor.processBasic(path.newSubPath("method"), FloatingRateIndexCalculationMethodEnum.class, getMethod(), this);
		processRosetta(path.newSubPath("fixing"), processor, FloatingRateIndexFixingDetails.class, getFixing());
		processor.processBasic(path.newSubPath("dayCountFraction"), DayCountFractionEnum.class, getDayCountFraction(), this);
		processRosetta(path.newSubPath("applicableBusinessDays"), processor, BusinessCenters.class, getApplicableBusinessDays());
		processor.processBasic(path.newSubPath("publicationCalendar"), BusinessCenterEnum.class, getPublicationCalendar(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FloatingRateIndexCalculationDefaultsBuilder extends FloatingRateIndexCalculationDefaults, RosettaModelObjectBuilder {
		FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder getOrCreateFixing(int index);
		@Override
		List<? extends FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder> getFixing();
		BusinessCenters.BusinessCentersBuilder getOrCreateApplicableBusinessDays();
		@Override
		BusinessCenters.BusinessCentersBuilder getApplicableBusinessDays();
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setCategory(FloatingRateIndexCategoryEnum category);
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setIndexStyle(FloatingRateIndexStyleEnum indexStyle);
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setMethod(FloatingRateIndexCalculationMethodEnum method);
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder addFixing(FloatingRateIndexFixingDetails fixing);
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder addFixing(FloatingRateIndexFixingDetails fixing, int idx);
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder addFixing(List<? extends FloatingRateIndexFixingDetails> fixing);
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setFixing(List<? extends FloatingRateIndexFixingDetails> fixing);
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setDayCountFraction(DayCountFractionEnum dayCountFraction);
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setApplicableBusinessDays(BusinessCenters applicableBusinessDays);
		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setPublicationCalendar(BusinessCenterEnum publicationCalendar);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("category"), FloatingRateIndexCategoryEnum.class, getCategory(), this);
			processor.processBasic(path.newSubPath("indexStyle"), FloatingRateIndexStyleEnum.class, getIndexStyle(), this);
			processor.processBasic(path.newSubPath("method"), FloatingRateIndexCalculationMethodEnum.class, getMethod(), this);
			processRosetta(path.newSubPath("fixing"), processor, FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder.class, getFixing());
			processor.processBasic(path.newSubPath("dayCountFraction"), DayCountFractionEnum.class, getDayCountFraction(), this);
			processRosetta(path.newSubPath("applicableBusinessDays"), processor, BusinessCenters.BusinessCentersBuilder.class, getApplicableBusinessDays());
			processor.processBasic(path.newSubPath("publicationCalendar"), BusinessCenterEnum.class, getPublicationCalendar(), this);
		}
		

		FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder prune();
	}

	/*********************** Immutable Implementation of FloatingRateIndexCalculationDefaults  ***********************/
	class FloatingRateIndexCalculationDefaultsImpl implements FloatingRateIndexCalculationDefaults {
		private final FloatingRateIndexCategoryEnum category;
		private final FloatingRateIndexStyleEnum indexStyle;
		private final FloatingRateIndexCalculationMethodEnum method;
		private final List<? extends FloatingRateIndexFixingDetails> fixing;
		private final DayCountFractionEnum dayCountFraction;
		private final BusinessCenters applicableBusinessDays;
		private final BusinessCenterEnum publicationCalendar;
		
		protected FloatingRateIndexCalculationDefaultsImpl(FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder builder) {
			this.category = builder.getCategory();
			this.indexStyle = builder.getIndexStyle();
			this.method = builder.getMethod();
			this.fixing = ofNullable(builder.getFixing()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.dayCountFraction = builder.getDayCountFraction();
			this.applicableBusinessDays = ofNullable(builder.getApplicableBusinessDays()).map(f->f.build()).orElse(null);
			this.publicationCalendar = builder.getPublicationCalendar();
		}
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("category")
		public FloatingRateIndexCategoryEnum getCategory() {
			return category;
		}
		
		@Override
		@RosettaAttribute("indexStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexStyle")
		public FloatingRateIndexStyleEnum getIndexStyle() {
			return indexStyle;
		}
		
		@Override
		@RosettaAttribute("method")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("method")
		public FloatingRateIndexCalculationMethodEnum getMethod() {
			return method;
		}
		
		@Override
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixing")
		public List<? extends FloatingRateIndexFixingDetails> getFixing() {
			return fixing;
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFractionEnum getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("applicableBusinessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableBusinessDays")
		public BusinessCenters getApplicableBusinessDays() {
			return applicableBusinessDays;
		}
		
		@Override
		@RosettaAttribute("publicationCalendar")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationCalendar")
		public BusinessCenterEnum getPublicationCalendar() {
			return publicationCalendar;
		}
		
		@Override
		public FloatingRateIndexCalculationDefaults build() {
			return this;
		}
		
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder toBuilder() {
			FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder builder) {
			ofNullable(getCategory()).ifPresent(builder::setCategory);
			ofNullable(getIndexStyle()).ifPresent(builder::setIndexStyle);
			ofNullable(getMethod()).ifPresent(builder::setMethod);
			ofNullable(getFixing()).ifPresent(builder::setFixing);
			ofNullable(getDayCountFraction()).ifPresent(builder::setDayCountFraction);
			ofNullable(getApplicableBusinessDays()).ifPresent(builder::setApplicableBusinessDays);
			ofNullable(getPublicationCalendar()).ifPresent(builder::setPublicationCalendar);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexCalculationDefaults _that = getType().cast(o);
		
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!Objects.equals(indexStyle, _that.getIndexStyle())) return false;
			if (!Objects.equals(method, _that.getMethod())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(applicableBusinessDays, _that.getApplicableBusinessDays())) return false;
			if (!Objects.equals(publicationCalendar, _that.getPublicationCalendar())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (category != null ? category.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexStyle != null ? indexStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (method != null ? method.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (applicableBusinessDays != null ? applicableBusinessDays.hashCode() : 0);
			_result = 31 * _result + (publicationCalendar != null ? publicationCalendar.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexCalculationDefaults {" +
				"category=" + this.category + ", " +
				"indexStyle=" + this.indexStyle + ", " +
				"method=" + this.method + ", " +
				"fixing=" + this.fixing + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"applicableBusinessDays=" + this.applicableBusinessDays + ", " +
				"publicationCalendar=" + this.publicationCalendar +
			'}';
		}
	}

	/*********************** Builder Implementation of FloatingRateIndexCalculationDefaults  ***********************/
	class FloatingRateIndexCalculationDefaultsBuilderImpl implements FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder {
	
		protected FloatingRateIndexCategoryEnum category;
		protected FloatingRateIndexStyleEnum indexStyle;
		protected FloatingRateIndexCalculationMethodEnum method;
		protected List<FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder> fixing = new ArrayList<>();
		protected DayCountFractionEnum dayCountFraction;
		protected BusinessCenters.BusinessCentersBuilder applicableBusinessDays;
		protected BusinessCenterEnum publicationCalendar;
		
		@Override
		@RosettaAttribute("category")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("category")
		public FloatingRateIndexCategoryEnum getCategory() {
			return category;
		}
		
		@Override
		@RosettaAttribute("indexStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexStyle")
		public FloatingRateIndexStyleEnum getIndexStyle() {
			return indexStyle;
		}
		
		@Override
		@RosettaAttribute("method")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("method")
		public FloatingRateIndexCalculationMethodEnum getMethod() {
			return method;
		}
		
		@Override
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("fixing")
		public List<? extends FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder> getFixing() {
			return fixing;
		}
		
		@Override
		public FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder getOrCreateFixing(int index) {
			if (fixing==null) {
				this.fixing = new ArrayList<>();
			}
			return getIndex(fixing, index, () -> {
						FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder newFixing = FloatingRateIndexFixingDetails.builder();
						return newFixing;
					});
		}
		
		@Override
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("dayCountFraction")
		public DayCountFractionEnum getDayCountFraction() {
			return dayCountFraction;
		}
		
		@Override
		@RosettaAttribute("applicableBusinessDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("applicableBusinessDays")
		public BusinessCenters.BusinessCentersBuilder getApplicableBusinessDays() {
			return applicableBusinessDays;
		}
		
		@Override
		public BusinessCenters.BusinessCentersBuilder getOrCreateApplicableBusinessDays() {
			BusinessCenters.BusinessCentersBuilder result;
			if (applicableBusinessDays!=null) {
				result = applicableBusinessDays;
			}
			else {
				result = applicableBusinessDays = BusinessCenters.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("publicationCalendar")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("publicationCalendar")
		public BusinessCenterEnum getPublicationCalendar() {
			return publicationCalendar;
		}
		
		@RosettaAttribute("category")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("category")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setCategory(FloatingRateIndexCategoryEnum _category) {
			this.category = _category == null ? null : _category;
			return this;
		}
		
		@RosettaAttribute("indexStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexStyle")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setIndexStyle(FloatingRateIndexStyleEnum _indexStyle) {
			this.indexStyle = _indexStyle == null ? null : _indexStyle;
			return this;
		}
		
		@RosettaAttribute("method")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("method")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setMethod(FloatingRateIndexCalculationMethodEnum _method) {
			this.method = _method == null ? null : _method;
			return this;
		}
		
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("fixing")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder addFixing(FloatingRateIndexFixingDetails _fixing) {
			if (_fixing != null) {
				this.fixing.add(_fixing.toBuilder());
			}
			return this;
		}
		
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder addFixing(FloatingRateIndexFixingDetails _fixing, int idx) {
			getIndex(this.fixing, idx, () -> _fixing.toBuilder());
			return this;
		}
		
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder addFixing(List<? extends FloatingRateIndexFixingDetails> fixings) {
			if (fixings != null) {
				for (final FloatingRateIndexFixingDetails toAdd : fixings) {
					this.fixing.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("fixing")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("fixing")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setFixing(List<? extends FloatingRateIndexFixingDetails> fixings) {
			if (fixings == null) {
				this.fixing = new ArrayList<>();
			} else {
				this.fixing = fixings.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("dayCountFraction")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("dayCountFraction")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setDayCountFraction(DayCountFractionEnum _dayCountFraction) {
			this.dayCountFraction = _dayCountFraction == null ? null : _dayCountFraction;
			return this;
		}
		
		@RosettaAttribute("applicableBusinessDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("applicableBusinessDays")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setApplicableBusinessDays(BusinessCenters _applicableBusinessDays) {
			this.applicableBusinessDays = _applicableBusinessDays == null ? null : _applicableBusinessDays.toBuilder();
			return this;
		}
		
		@RosettaAttribute("publicationCalendar")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("publicationCalendar")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder setPublicationCalendar(BusinessCenterEnum _publicationCalendar) {
			this.publicationCalendar = _publicationCalendar == null ? null : _publicationCalendar;
			return this;
		}
		
		@Override
		public FloatingRateIndexCalculationDefaults build() {
			return new FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsImpl(this);
		}
		
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder prune() {
			fixing = fixing.stream().filter(b->b!=null).<FloatingRateIndexFixingDetails.FloatingRateIndexFixingDetailsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (applicableBusinessDays!=null && !applicableBusinessDays.prune().hasData()) applicableBusinessDays = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCategory()!=null) return true;
			if (getIndexStyle()!=null) return true;
			if (getMethod()!=null) return true;
			if (getFixing()!=null && getFixing().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getDayCountFraction()!=null) return true;
			if (getApplicableBusinessDays()!=null && getApplicableBusinessDays().hasData()) return true;
			if (getPublicationCalendar()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder o = (FloatingRateIndexCalculationDefaults.FloatingRateIndexCalculationDefaultsBuilder) other;
			
			merger.mergeRosetta(getFixing(), o.getFixing(), this::getOrCreateFixing);
			merger.mergeRosetta(getApplicableBusinessDays(), o.getApplicableBusinessDays(), this::setApplicableBusinessDays);
			
			merger.mergeBasic(getCategory(), o.getCategory(), this::setCategory);
			merger.mergeBasic(getIndexStyle(), o.getIndexStyle(), this::setIndexStyle);
			merger.mergeBasic(getMethod(), o.getMethod(), this::setMethod);
			merger.mergeBasic(getDayCountFraction(), o.getDayCountFraction(), this::setDayCountFraction);
			merger.mergeBasic(getPublicationCalendar(), o.getPublicationCalendar(), this::setPublicationCalendar);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FloatingRateIndexCalculationDefaults _that = getType().cast(o);
		
			if (!Objects.equals(category, _that.getCategory())) return false;
			if (!Objects.equals(indexStyle, _that.getIndexStyle())) return false;
			if (!Objects.equals(method, _that.getMethod())) return false;
			if (!ListEquals.listEquals(fixing, _that.getFixing())) return false;
			if (!Objects.equals(dayCountFraction, _that.getDayCountFraction())) return false;
			if (!Objects.equals(applicableBusinessDays, _that.getApplicableBusinessDays())) return false;
			if (!Objects.equals(publicationCalendar, _that.getPublicationCalendar())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (category != null ? category.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (indexStyle != null ? indexStyle.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (method != null ? method.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (fixing != null ? fixing.hashCode() : 0);
			_result = 31 * _result + (dayCountFraction != null ? dayCountFraction.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (applicableBusinessDays != null ? applicableBusinessDays.hashCode() : 0);
			_result = 31 * _result + (publicationCalendar != null ? publicationCalendar.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FloatingRateIndexCalculationDefaultsBuilder {" +
				"category=" + this.category + ", " +
				"indexStyle=" + this.indexStyle + ", " +
				"method=" + this.method + ", " +
				"fixing=" + this.fixing + ", " +
				"dayCountFraction=" + this.dayCountFraction + ", " +
				"applicableBusinessDays=" + this.applicableBusinessDays + ", " +
				"publicationCalendar=" + this.publicationCalendar +
			'}';
		}
	}
}
