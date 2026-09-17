package fpml.consolidated.reg.fpmlreporting.product;

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
import fpml.consolidated.fpmlenum.OptionTypeEnum;
import fpml.consolidated.generic.GenericExerciseStyle;
import fpml.consolidated.generic.GenericProductFeature;
import fpml.consolidated.reg.fpmlreporting.product.meta.RegulatoryReportingNonCDEOptionDetailsMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision This defines data elements not defined in CDE that describe option characteristics. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
 *
 */
@RosettaDataType(value="RegulatoryReportingNonCDEOptionDetails", builder=RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingNonCDEOptionDetails", model="fpml", builder=RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingNonCDEOptionDetails extends RosettaModelObject {

	RegulatoryReportingNonCDEOptionDetailsMeta metaData = new RegulatoryReportingNonCDEOptionDetailsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For options, what type of option it is (e.g. butterfly). DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	OptionTypeEnum getOptionType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<ZonedDateTime> getFirstExerciseDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<ZonedDateTime> getOptionExpirationDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<ZonedDateTime> getUnderlyerMaturityDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision For options, whether the option is a put or call option. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	GenericExerciseStyle getExerciseStyle();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Special features that the option may have, such as Asian averaging, Barriers, Digital payout, etc. DEPRECATED. Reason: Not used, deprecated parent element. (RPTWG decision 2024-05-30)
	 *
	 */
	List<? extends GenericProductFeature> getFeature();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingNonCDEOptionDetails build();
	
	RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder toBuilder();
	
	static RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder builder() {
		return new RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingNonCDEOptionDetails> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingNonCDEOptionDetails> getType() {
		return RegulatoryReportingNonCDEOptionDetails.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
		processor.processBasic(path.newSubPath("firstExerciseDate"), ZonedDateTime.class, getFirstExerciseDate(), this);
		processor.processBasic(path.newSubPath("optionExpirationDate"), ZonedDateTime.class, getOptionExpirationDate(), this);
		processor.processBasic(path.newSubPath("underlyerMaturityDate"), ZonedDateTime.class, getUnderlyerMaturityDate(), this);
		processRosetta(path.newSubPath("exerciseStyle"), processor, GenericExerciseStyle.class, getExerciseStyle());
		processRosetta(path.newSubPath("feature"), processor, GenericProductFeature.class, getFeature());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingNonCDEOptionDetailsBuilder extends RegulatoryReportingNonCDEOptionDetails, RosettaModelObjectBuilder {
		GenericExerciseStyle.GenericExerciseStyleBuilder getOrCreateExerciseStyle();
		@Override
		GenericExerciseStyle.GenericExerciseStyleBuilder getExerciseStyle();
		GenericProductFeature.GenericProductFeatureBuilder getOrCreateFeature(int index);
		@Override
		List<? extends GenericProductFeature.GenericProductFeatureBuilder> getFeature();
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setOptionType(OptionTypeEnum optionType);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFirstExerciseDate(ZonedDateTime firstExerciseDate);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFirstExerciseDate(ZonedDateTime firstExerciseDate, int idx);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFirstExerciseDate(List<ZonedDateTime> firstExerciseDate);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setFirstExerciseDate(List<ZonedDateTime> firstExerciseDate);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addOptionExpirationDate(ZonedDateTime optionExpirationDate);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addOptionExpirationDate(ZonedDateTime optionExpirationDate, int idx);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addOptionExpirationDate(List<ZonedDateTime> optionExpirationDate);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setOptionExpirationDate(List<ZonedDateTime> optionExpirationDate);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addUnderlyerMaturityDate(ZonedDateTime underlyerMaturityDate);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addUnderlyerMaturityDate(ZonedDateTime underlyerMaturityDate, int idx);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addUnderlyerMaturityDate(List<ZonedDateTime> underlyerMaturityDate);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setUnderlyerMaturityDate(List<ZonedDateTime> underlyerMaturityDate);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setExerciseStyle(GenericExerciseStyle exerciseStyle);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFeature(GenericProductFeature feature);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFeature(GenericProductFeature feature, int idx);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFeature(List<? extends GenericProductFeature> feature);
		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setFeature(List<? extends GenericProductFeature> feature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("optionType"), OptionTypeEnum.class, getOptionType(), this);
			processor.processBasic(path.newSubPath("firstExerciseDate"), ZonedDateTime.class, getFirstExerciseDate(), this);
			processor.processBasic(path.newSubPath("optionExpirationDate"), ZonedDateTime.class, getOptionExpirationDate(), this);
			processor.processBasic(path.newSubPath("underlyerMaturityDate"), ZonedDateTime.class, getUnderlyerMaturityDate(), this);
			processRosetta(path.newSubPath("exerciseStyle"), processor, GenericExerciseStyle.GenericExerciseStyleBuilder.class, getExerciseStyle());
			processRosetta(path.newSubPath("feature"), processor, GenericProductFeature.GenericProductFeatureBuilder.class, getFeature());
		}
		

		RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingNonCDEOptionDetails  ***********************/
	class RegulatoryReportingNonCDEOptionDetailsImpl implements RegulatoryReportingNonCDEOptionDetails {
		private final OptionTypeEnum optionType;
		private final List<ZonedDateTime> firstExerciseDate;
		private final List<ZonedDateTime> optionExpirationDate;
		private final List<ZonedDateTime> underlyerMaturityDate;
		private final GenericExerciseStyle exerciseStyle;
		private final List<? extends GenericProductFeature> feature;
		
		protected RegulatoryReportingNonCDEOptionDetailsImpl(RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder builder) {
			this.optionType = builder.getOptionType();
			this.firstExerciseDate = ofNullable(builder.getFirstExerciseDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.optionExpirationDate = ofNullable(builder.getOptionExpirationDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.underlyerMaturityDate = ofNullable(builder.getUnderlyerMaturityDate()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
			this.exerciseStyle = ofNullable(builder.getExerciseStyle()).map(f->f.build()).orElse(null);
			this.feature = ofNullable(builder.getFeature()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("firstExerciseDate")
		public List<ZonedDateTime> getFirstExerciseDate() {
			return firstExerciseDate;
		}
		
		@Override
		@RosettaAttribute("optionExpirationDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionExpirationDate")
		public List<ZonedDateTime> getOptionExpirationDate() {
			return optionExpirationDate;
		}
		
		@Override
		@RosettaAttribute("underlyerMaturityDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyerMaturityDate")
		public List<ZonedDateTime> getUnderlyerMaturityDate() {
			return underlyerMaturityDate;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseStyle")
		public GenericExerciseStyle getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("feature")
		public List<? extends GenericProductFeature> getFeature() {
			return feature;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder toBuilder() {
			RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder builder) {
			ofNullable(getOptionType()).ifPresent(builder::setOptionType);
			ofNullable(getFirstExerciseDate()).ifPresent(builder::setFirstExerciseDate);
			ofNullable(getOptionExpirationDate()).ifPresent(builder::setOptionExpirationDate);
			ofNullable(getUnderlyerMaturityDate()).ifPresent(builder::setUnderlyerMaturityDate);
			ofNullable(getExerciseStyle()).ifPresent(builder::setExerciseStyle);
			ofNullable(getFeature()).ifPresent(builder::setFeature);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingNonCDEOptionDetails _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!ListEquals.listEquals(firstExerciseDate, _that.getFirstExerciseDate())) return false;
			if (!ListEquals.listEquals(optionExpirationDate, _that.getOptionExpirationDate())) return false;
			if (!ListEquals.listEquals(underlyerMaturityDate, _that.getUnderlyerMaturityDate())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (firstExerciseDate != null ? firstExerciseDate.hashCode() : 0);
			_result = 31 * _result + (optionExpirationDate != null ? optionExpirationDate.hashCode() : 0);
			_result = 31 * _result + (underlyerMaturityDate != null ? underlyerMaturityDate.hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingNonCDEOptionDetails {" +
				"optionType=" + this.optionType + ", " +
				"firstExerciseDate=" + this.firstExerciseDate + ", " +
				"optionExpirationDate=" + this.optionExpirationDate + ", " +
				"underlyerMaturityDate=" + this.underlyerMaturityDate + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"feature=" + this.feature +
			'}';
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingNonCDEOptionDetails  ***********************/
	class RegulatoryReportingNonCDEOptionDetailsBuilderImpl implements RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder {
	
		protected OptionTypeEnum optionType;
		protected List<ZonedDateTime> firstExerciseDate = new ArrayList<>();
		protected List<ZonedDateTime> optionExpirationDate = new ArrayList<>();
		protected List<ZonedDateTime> underlyerMaturityDate = new ArrayList<>();
		protected GenericExerciseStyle.GenericExerciseStyleBuilder exerciseStyle;
		protected List<GenericProductFeature.GenericProductFeatureBuilder> feature = new ArrayList<>();
		
		@Override
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("optionType")
		public OptionTypeEnum getOptionType() {
			return optionType;
		}
		
		@Override
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("firstExerciseDate")
		public List<ZonedDateTime> getFirstExerciseDate() {
			return firstExerciseDate;
		}
		
		@Override
		@RosettaAttribute("optionExpirationDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("optionExpirationDate")
		public List<ZonedDateTime> getOptionExpirationDate() {
			return optionExpirationDate;
		}
		
		@Override
		@RosettaAttribute("underlyerMaturityDate")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("underlyerMaturityDate")
		public List<ZonedDateTime> getUnderlyerMaturityDate() {
			return underlyerMaturityDate;
		}
		
		@Override
		@RosettaAttribute("exerciseStyle")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("exerciseStyle")
		public GenericExerciseStyle.GenericExerciseStyleBuilder getExerciseStyle() {
			return exerciseStyle;
		}
		
		@Override
		public GenericExerciseStyle.GenericExerciseStyleBuilder getOrCreateExerciseStyle() {
			GenericExerciseStyle.GenericExerciseStyleBuilder result;
			if (exerciseStyle!=null) {
				result = exerciseStyle;
			}
			else {
				result = exerciseStyle = GenericExerciseStyle.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("feature")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("feature")
		public List<? extends GenericProductFeature.GenericProductFeatureBuilder> getFeature() {
			return feature;
		}
		
		@Override
		public GenericProductFeature.GenericProductFeatureBuilder getOrCreateFeature(int index) {
			if (feature==null) {
				this.feature = new ArrayList<>();
			}
			return getIndex(feature, index, () -> {
						GenericProductFeature.GenericProductFeatureBuilder newFeature = GenericProductFeature.builder();
						return newFeature;
					});
		}
		
		@RosettaAttribute("optionType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("optionType")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setOptionType(OptionTypeEnum _optionType) {
			this.optionType = _optionType == null ? null : _optionType;
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("firstExerciseDate")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFirstExerciseDate(ZonedDateTime _firstExerciseDate) {
			if (_firstExerciseDate != null) {
				this.firstExerciseDate.add(_firstExerciseDate);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFirstExerciseDate(ZonedDateTime _firstExerciseDate, int idx) {
			getIndex(this.firstExerciseDate, idx, () -> _firstExerciseDate);
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFirstExerciseDate(List<ZonedDateTime> firstExerciseDates) {
			if (firstExerciseDates != null) {
				for (final ZonedDateTime toAdd : firstExerciseDates) {
					this.firstExerciseDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("firstExerciseDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("firstExerciseDate")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setFirstExerciseDate(List<ZonedDateTime> firstExerciseDates) {
			if (firstExerciseDates == null) {
				this.firstExerciseDate = new ArrayList<>();
			} else {
				this.firstExerciseDate = firstExerciseDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("optionExpirationDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("optionExpirationDate")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addOptionExpirationDate(ZonedDateTime _optionExpirationDate) {
			if (_optionExpirationDate != null) {
				this.optionExpirationDate.add(_optionExpirationDate);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addOptionExpirationDate(ZonedDateTime _optionExpirationDate, int idx) {
			getIndex(this.optionExpirationDate, idx, () -> _optionExpirationDate);
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addOptionExpirationDate(List<ZonedDateTime> optionExpirationDates) {
			if (optionExpirationDates != null) {
				for (final ZonedDateTime toAdd : optionExpirationDates) {
					this.optionExpirationDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("optionExpirationDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("optionExpirationDate")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setOptionExpirationDate(List<ZonedDateTime> optionExpirationDates) {
			if (optionExpirationDates == null) {
				this.optionExpirationDate = new ArrayList<>();
			} else {
				this.optionExpirationDate = optionExpirationDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("underlyerMaturityDate")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("underlyerMaturityDate")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addUnderlyerMaturityDate(ZonedDateTime _underlyerMaturityDate) {
			if (_underlyerMaturityDate != null) {
				this.underlyerMaturityDate.add(_underlyerMaturityDate);
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addUnderlyerMaturityDate(ZonedDateTime _underlyerMaturityDate, int idx) {
			getIndex(this.underlyerMaturityDate, idx, () -> _underlyerMaturityDate);
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addUnderlyerMaturityDate(List<ZonedDateTime> underlyerMaturityDates) {
			if (underlyerMaturityDates != null) {
				for (final ZonedDateTime toAdd : underlyerMaturityDates) {
					this.underlyerMaturityDate.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("underlyerMaturityDate")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("underlyerMaturityDate")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setUnderlyerMaturityDate(List<ZonedDateTime> underlyerMaturityDates) {
			if (underlyerMaturityDates == null) {
				this.underlyerMaturityDate = new ArrayList<>();
			} else {
				this.underlyerMaturityDate = underlyerMaturityDates.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("exerciseStyle")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("exerciseStyle")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setExerciseStyle(GenericExerciseStyle _exerciseStyle) {
			this.exerciseStyle = _exerciseStyle == null ? null : _exerciseStyle.toBuilder();
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFeature(GenericProductFeature _feature) {
			if (_feature != null) {
				this.feature.add(_feature.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFeature(GenericProductFeature _feature, int idx) {
			getIndex(this.feature, idx, () -> _feature.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder addFeature(List<? extends GenericProductFeature> features) {
			if (features != null) {
				for (final GenericProductFeature toAdd : features) {
					this.feature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("feature")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("feature")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder setFeature(List<? extends GenericProductFeature> features) {
			if (features == null) {
				this.feature = new ArrayList<>();
			} else {
				this.feature = features.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails build() {
			return new RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsImpl(this);
		}
		
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder prune() {
			if (exerciseStyle!=null && !exerciseStyle.prune().hasData()) exerciseStyle = null;
			feature = feature.stream().filter(b->b!=null).<GenericProductFeature.GenericProductFeatureBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionType()!=null) return true;
			if (getFirstExerciseDate()!=null && !getFirstExerciseDate().isEmpty()) return true;
			if (getOptionExpirationDate()!=null && !getOptionExpirationDate().isEmpty()) return true;
			if (getUnderlyerMaturityDate()!=null && !getUnderlyerMaturityDate().isEmpty()) return true;
			if (getExerciseStyle()!=null && getExerciseStyle().hasData()) return true;
			if (getFeature()!=null && getFeature().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder o = (RegulatoryReportingNonCDEOptionDetails.RegulatoryReportingNonCDEOptionDetailsBuilder) other;
			
			merger.mergeRosetta(getExerciseStyle(), o.getExerciseStyle(), this::setExerciseStyle);
			merger.mergeRosetta(getFeature(), o.getFeature(), this::getOrCreateFeature);
			
			merger.mergeBasic(getOptionType(), o.getOptionType(), this::setOptionType);
			merger.mergeBasic(getFirstExerciseDate(), o.getFirstExerciseDate(), (Consumer<ZonedDateTime>) this::addFirstExerciseDate);
			merger.mergeBasic(getOptionExpirationDate(), o.getOptionExpirationDate(), (Consumer<ZonedDateTime>) this::addOptionExpirationDate);
			merger.mergeBasic(getUnderlyerMaturityDate(), o.getUnderlyerMaturityDate(), (Consumer<ZonedDateTime>) this::addUnderlyerMaturityDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RegulatoryReportingNonCDEOptionDetails _that = getType().cast(o);
		
			if (!Objects.equals(optionType, _that.getOptionType())) return false;
			if (!ListEquals.listEquals(firstExerciseDate, _that.getFirstExerciseDate())) return false;
			if (!ListEquals.listEquals(optionExpirationDate, _that.getOptionExpirationDate())) return false;
			if (!ListEquals.listEquals(underlyerMaturityDate, _that.getUnderlyerMaturityDate())) return false;
			if (!Objects.equals(exerciseStyle, _that.getExerciseStyle())) return false;
			if (!ListEquals.listEquals(feature, _that.getFeature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionType != null ? optionType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (firstExerciseDate != null ? firstExerciseDate.hashCode() : 0);
			_result = 31 * _result + (optionExpirationDate != null ? optionExpirationDate.hashCode() : 0);
			_result = 31 * _result + (underlyerMaturityDate != null ? underlyerMaturityDate.hashCode() : 0);
			_result = 31 * _result + (exerciseStyle != null ? exerciseStyle.hashCode() : 0);
			_result = 31 * _result + (feature != null ? feature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingNonCDEOptionDetailsBuilder {" +
				"optionType=" + this.optionType + ", " +
				"firstExerciseDate=" + this.firstExerciseDate + ", " +
				"optionExpirationDate=" + this.optionExpirationDate + ", " +
				"underlyerMaturityDate=" + this.underlyerMaturityDate + ", " +
				"exerciseStyle=" + this.exerciseStyle + ", " +
				"feature=" + this.feature +
			'}';
		}
	}
}
