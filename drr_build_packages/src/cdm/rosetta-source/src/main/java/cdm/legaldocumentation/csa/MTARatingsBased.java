package cdm.legaldocumentation.csa;

import cdm.base.staticdata.asset.common.ISOCurrencyCodeEnum;
import cdm.base.staticdata.party.CounterpartyRoleEnum;
import cdm.legaldocumentation.csa.meta.MTARatingsBasedMeta;
import cdm.observable.asset.CreditNotationMismatchResolutionEnum;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
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
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Defines that the Minimum Transfer Amount (MTA) is based on a Ratings condition(s).
 * @version 6.23.0
 */
@RosettaDataType(value="MTARatingsBased", builder=MTARatingsBased.MTARatingsBasedBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MTARatingsBased", model="cdm", builder=MTARatingsBased.MTARatingsBasedBuilderImpl.class, version="6.23.0")
public interface MTARatingsBased extends RosettaModelObject {

	MTARatingsBasedMeta metaData = new MTARatingsBasedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The party to which the Minimum Transfer Amount (MTA) applies.
	 */
	CounterpartyRoleEnum getParty();
	/**
	 * The minimum transfer amount currency code.
	 */
	ISOCurrencyCodeEnum getCurrency();
	/**
	 * The relevant rating type.
	 */
	RatingTypeEnum getRatingType();
	/**
	 * Defines a combination of Rating Agency, Rating Value, amount and Currency code.
	 */
	List<? extends CSAMTAVariableSet> getVariableSet();
	/**
	 * The party to which a rating applies.
	 */
	MTARatedPartyEnum getRatedParty();
	/**
	 * Details the Named Entity where the Rated Party is Named Entity.
	 */
	String getNamedEntity();
	/**
	 * Details the Named Affiliate where the Rated Party is Named Affiliate.
	 */
	String getNamedAffiliate();
	/**
	 * Where two ratings are specified whether the higher or lower rating prevails.
	 */
	CreditNotationMismatchResolutionEnum getCompare();
	/**
	 * What conditions apply where a party has no rating.
	 */
	Boolean getNoRating();
	/**
	 * Defines where conditions apply if no Rating where ratings may not exist.
	 */
	NotRatedByEnum getNotRatedBy();
	/**
	 * Defines the number of Rating Agencies that the Party must be rated by.
	 */
	NumberOfRatingAgenciesEnum getNumberOfRatingAgencies();
	/**
	 * Whether a trigger applies for the threshold to fall to zero.
	 */
	Boolean getZeroEvent();
	/**
	 * The relevant trigger for the to fall to zero.
	 */
	List<MTAZeroEventEnum> getEvent();

	/*********************** Build Methods  ***********************/
	MTARatingsBased build();
	
	MTARatingsBased.MTARatingsBasedBuilder toBuilder();
	
	static MTARatingsBased.MTARatingsBasedBuilder builder() {
		return new MTARatingsBased.MTARatingsBasedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MTARatingsBased> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MTARatingsBased> getType() {
		return MTARatingsBased.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
		processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
		processor.processBasic(path.newSubPath("ratingType"), RatingTypeEnum.class, getRatingType(), this);
		processRosetta(path.newSubPath("variableSet"), processor, CSAMTAVariableSet.class, getVariableSet());
		processor.processBasic(path.newSubPath("ratedParty"), MTARatedPartyEnum.class, getRatedParty(), this);
		processor.processBasic(path.newSubPath("namedEntity"), String.class, getNamedEntity(), this);
		processor.processBasic(path.newSubPath("namedAffiliate"), String.class, getNamedAffiliate(), this);
		processor.processBasic(path.newSubPath("compare"), CreditNotationMismatchResolutionEnum.class, getCompare(), this);
		processor.processBasic(path.newSubPath("noRating"), Boolean.class, getNoRating(), this);
		processor.processBasic(path.newSubPath("notRatedBy"), NotRatedByEnum.class, getNotRatedBy(), this);
		processor.processBasic(path.newSubPath("numberOfRatingAgencies"), NumberOfRatingAgenciesEnum.class, getNumberOfRatingAgencies(), this);
		processor.processBasic(path.newSubPath("zeroEvent"), Boolean.class, getZeroEvent(), this);
		processor.processBasic(path.newSubPath("event"), MTAZeroEventEnum.class, getEvent(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MTARatingsBasedBuilder extends MTARatingsBased, RosettaModelObjectBuilder {
		CSAMTAVariableSet.CSAMTAVariableSetBuilder getOrCreateVariableSet(int index);
		@Override
		List<? extends CSAMTAVariableSet.CSAMTAVariableSetBuilder> getVariableSet();
		MTARatingsBased.MTARatingsBasedBuilder setParty(CounterpartyRoleEnum party);
		MTARatingsBased.MTARatingsBasedBuilder setCurrency(ISOCurrencyCodeEnum currency);
		MTARatingsBased.MTARatingsBasedBuilder setRatingType(RatingTypeEnum ratingType);
		MTARatingsBased.MTARatingsBasedBuilder addVariableSet(CSAMTAVariableSet variableSet);
		MTARatingsBased.MTARatingsBasedBuilder addVariableSet(CSAMTAVariableSet variableSet, int idx);
		MTARatingsBased.MTARatingsBasedBuilder addVariableSet(List<? extends CSAMTAVariableSet> variableSet);
		MTARatingsBased.MTARatingsBasedBuilder setVariableSet(List<? extends CSAMTAVariableSet> variableSet);
		MTARatingsBased.MTARatingsBasedBuilder setRatedParty(MTARatedPartyEnum ratedParty);
		MTARatingsBased.MTARatingsBasedBuilder setNamedEntity(String namedEntity);
		MTARatingsBased.MTARatingsBasedBuilder setNamedAffiliate(String namedAffiliate);
		MTARatingsBased.MTARatingsBasedBuilder setCompare(CreditNotationMismatchResolutionEnum compare);
		MTARatingsBased.MTARatingsBasedBuilder setNoRating(Boolean noRating);
		MTARatingsBased.MTARatingsBasedBuilder setNotRatedBy(NotRatedByEnum notRatedBy);
		MTARatingsBased.MTARatingsBasedBuilder setNumberOfRatingAgencies(NumberOfRatingAgenciesEnum numberOfRatingAgencies);
		MTARatingsBased.MTARatingsBasedBuilder setZeroEvent(Boolean zeroEvent);
		MTARatingsBased.MTARatingsBasedBuilder addEvent(MTAZeroEventEnum event);
		MTARatingsBased.MTARatingsBasedBuilder addEvent(MTAZeroEventEnum event, int idx);
		MTARatingsBased.MTARatingsBasedBuilder addEvent(List<MTAZeroEventEnum> event);
		MTARatingsBased.MTARatingsBasedBuilder setEvent(List<MTAZeroEventEnum> event);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("party"), CounterpartyRoleEnum.class, getParty(), this);
			processor.processBasic(path.newSubPath("currency"), ISOCurrencyCodeEnum.class, getCurrency(), this);
			processor.processBasic(path.newSubPath("ratingType"), RatingTypeEnum.class, getRatingType(), this);
			processRosetta(path.newSubPath("variableSet"), processor, CSAMTAVariableSet.CSAMTAVariableSetBuilder.class, getVariableSet());
			processor.processBasic(path.newSubPath("ratedParty"), MTARatedPartyEnum.class, getRatedParty(), this);
			processor.processBasic(path.newSubPath("namedEntity"), String.class, getNamedEntity(), this);
			processor.processBasic(path.newSubPath("namedAffiliate"), String.class, getNamedAffiliate(), this);
			processor.processBasic(path.newSubPath("compare"), CreditNotationMismatchResolutionEnum.class, getCompare(), this);
			processor.processBasic(path.newSubPath("noRating"), Boolean.class, getNoRating(), this);
			processor.processBasic(path.newSubPath("notRatedBy"), NotRatedByEnum.class, getNotRatedBy(), this);
			processor.processBasic(path.newSubPath("numberOfRatingAgencies"), NumberOfRatingAgenciesEnum.class, getNumberOfRatingAgencies(), this);
			processor.processBasic(path.newSubPath("zeroEvent"), Boolean.class, getZeroEvent(), this);
			processor.processBasic(path.newSubPath("event"), MTAZeroEventEnum.class, getEvent(), this);
		}
		

		MTARatingsBased.MTARatingsBasedBuilder prune();
	}

	/*********************** Immutable Implementation of MTARatingsBased  ***********************/
	class MTARatingsBasedImpl implements MTARatingsBased {
		private final CounterpartyRoleEnum party;
		private final ISOCurrencyCodeEnum currency;
		private final RatingTypeEnum ratingType;
		private final List<? extends CSAMTAVariableSet> variableSet;
		private final MTARatedPartyEnum ratedParty;
		private final String namedEntity;
		private final String namedAffiliate;
		private final CreditNotationMismatchResolutionEnum compare;
		private final Boolean noRating;
		private final NotRatedByEnum notRatedBy;
		private final NumberOfRatingAgenciesEnum numberOfRatingAgencies;
		private final Boolean zeroEvent;
		private final List<MTAZeroEventEnum> event;
		
		protected MTARatingsBasedImpl(MTARatingsBased.MTARatingsBasedBuilder builder) {
			this.party = builder.getParty();
			this.currency = builder.getCurrency();
			this.ratingType = builder.getRatingType();
			this.variableSet = ofNullable(builder.getVariableSet()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.ratedParty = builder.getRatedParty();
			this.namedEntity = builder.getNamedEntity();
			this.namedAffiliate = builder.getNamedAffiliate();
			this.compare = builder.getCompare();
			this.noRating = builder.getNoRating();
			this.notRatedBy = builder.getNotRatedBy();
			this.numberOfRatingAgencies = builder.getNumberOfRatingAgencies();
			this.zeroEvent = builder.getZeroEvent();
			this.event = ofNullable(builder.getEvent()).filter(_l->!_l.isEmpty()).map(ImmutableList::copyOf).orElse(null);
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("ratingType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ratingType")
		public RatingTypeEnum getRatingType() {
			return ratingType;
		}
		
		@Override
		@RosettaAttribute("variableSet")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("variableSet")
		public List<? extends CSAMTAVariableSet> getVariableSet() {
			return variableSet;
		}
		
		@Override
		@RosettaAttribute("ratedParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratedParty")
		public MTARatedPartyEnum getRatedParty() {
			return ratedParty;
		}
		
		@Override
		@RosettaAttribute("namedEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("namedEntity")
		public String getNamedEntity() {
			return namedEntity;
		}
		
		@Override
		@RosettaAttribute("namedAffiliate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("namedAffiliate")
		public String getNamedAffiliate() {
			return namedAffiliate;
		}
		
		@Override
		@RosettaAttribute("compare")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compare")
		public CreditNotationMismatchResolutionEnum getCompare() {
			return compare;
		}
		
		@Override
		@RosettaAttribute("noRating")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("noRating")
		public Boolean getNoRating() {
			return noRating;
		}
		
		@Override
		@RosettaAttribute("notRatedBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notRatedBy")
		public NotRatedByEnum getNotRatedBy() {
			return notRatedBy;
		}
		
		@Override
		@RosettaAttribute("numberOfRatingAgencies")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfRatingAgencies")
		public NumberOfRatingAgenciesEnum getNumberOfRatingAgencies() {
			return numberOfRatingAgencies;
		}
		
		@Override
		@RosettaAttribute("zeroEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("zeroEvent")
		public Boolean getZeroEvent() {
			return zeroEvent;
		}
		
		@Override
		@RosettaAttribute("event")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("event")
		public List<MTAZeroEventEnum> getEvent() {
			return event;
		}
		
		@Override
		public MTARatingsBased build() {
			return this;
		}
		
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder toBuilder() {
			MTARatingsBased.MTARatingsBasedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MTARatingsBased.MTARatingsBasedBuilder builder) {
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getCurrency()).ifPresent(builder::setCurrency);
			ofNullable(getRatingType()).ifPresent(builder::setRatingType);
			ofNullable(getVariableSet()).ifPresent(builder::setVariableSet);
			ofNullable(getRatedParty()).ifPresent(builder::setRatedParty);
			ofNullable(getNamedEntity()).ifPresent(builder::setNamedEntity);
			ofNullable(getNamedAffiliate()).ifPresent(builder::setNamedAffiliate);
			ofNullable(getCompare()).ifPresent(builder::setCompare);
			ofNullable(getNoRating()).ifPresent(builder::setNoRating);
			ofNullable(getNotRatedBy()).ifPresent(builder::setNotRatedBy);
			ofNullable(getNumberOfRatingAgencies()).ifPresent(builder::setNumberOfRatingAgencies);
			ofNullable(getZeroEvent()).ifPresent(builder::setZeroEvent);
			ofNullable(getEvent()).ifPresent(builder::setEvent);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MTARatingsBased _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(ratingType, _that.getRatingType())) return false;
			if (!ListEquals.listEquals(variableSet, _that.getVariableSet())) return false;
			if (!Objects.equals(ratedParty, _that.getRatedParty())) return false;
			if (!Objects.equals(namedEntity, _that.getNamedEntity())) return false;
			if (!Objects.equals(namedAffiliate, _that.getNamedAffiliate())) return false;
			if (!Objects.equals(compare, _that.getCompare())) return false;
			if (!Objects.equals(noRating, _that.getNoRating())) return false;
			if (!Objects.equals(notRatedBy, _that.getNotRatedBy())) return false;
			if (!Objects.equals(numberOfRatingAgencies, _that.getNumberOfRatingAgencies())) return false;
			if (!Objects.equals(zeroEvent, _that.getZeroEvent())) return false;
			if (!ListEquals.listEquals(event, _that.getEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ratingType != null ? ratingType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (variableSet != null ? variableSet.hashCode() : 0);
			_result = 31 * _result + (ratedParty != null ? ratedParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (namedEntity != null ? namedEntity.hashCode() : 0);
			_result = 31 * _result + (namedAffiliate != null ? namedAffiliate.hashCode() : 0);
			_result = 31 * _result + (compare != null ? compare.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (noRating != null ? noRating.hashCode() : 0);
			_result = 31 * _result + (notRatedBy != null ? notRatedBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (numberOfRatingAgencies != null ? numberOfRatingAgencies.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (zeroEvent != null ? zeroEvent.hashCode() : 0);
			_result = 31 * _result + (event != null ? event.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MTARatingsBased {" +
				"party=" + this.party + ", " +
				"currency=" + this.currency + ", " +
				"ratingType=" + this.ratingType + ", " +
				"variableSet=" + this.variableSet + ", " +
				"ratedParty=" + this.ratedParty + ", " +
				"namedEntity=" + this.namedEntity + ", " +
				"namedAffiliate=" + this.namedAffiliate + ", " +
				"compare=" + this.compare + ", " +
				"noRating=" + this.noRating + ", " +
				"notRatedBy=" + this.notRatedBy + ", " +
				"numberOfRatingAgencies=" + this.numberOfRatingAgencies + ", " +
				"zeroEvent=" + this.zeroEvent + ", " +
				"event=" + this.event +
			'}';
		}
	}

	/*********************** Builder Implementation of MTARatingsBased  ***********************/
	class MTARatingsBasedBuilderImpl implements MTARatingsBased.MTARatingsBasedBuilder {
	
		protected CounterpartyRoleEnum party;
		protected ISOCurrencyCodeEnum currency;
		protected RatingTypeEnum ratingType;
		protected List<CSAMTAVariableSet.CSAMTAVariableSetBuilder> variableSet = new ArrayList<>();
		protected MTARatedPartyEnum ratedParty;
		protected String namedEntity;
		protected String namedAffiliate;
		protected CreditNotationMismatchResolutionEnum compare;
		protected Boolean noRating;
		protected NotRatedByEnum notRatedBy;
		protected NumberOfRatingAgenciesEnum numberOfRatingAgencies;
		protected Boolean zeroEvent;
		protected List<MTAZeroEventEnum> event = new ArrayList<>();
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("party")
		public CounterpartyRoleEnum getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("currency")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("currency")
		public ISOCurrencyCodeEnum getCurrency() {
			return currency;
		}
		
		@Override
		@RosettaAttribute("ratingType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("ratingType")
		public RatingTypeEnum getRatingType() {
			return ratingType;
		}
		
		@Override
		@RosettaAttribute("variableSet")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("variableSet")
		public List<? extends CSAMTAVariableSet.CSAMTAVariableSetBuilder> getVariableSet() {
			return variableSet;
		}
		
		@Override
		public CSAMTAVariableSet.CSAMTAVariableSetBuilder getOrCreateVariableSet(int index) {
			if (variableSet==null) {
				this.variableSet = new ArrayList<>();
			}
			return getIndex(variableSet, index, () -> {
						CSAMTAVariableSet.CSAMTAVariableSetBuilder newVariableSet = CSAMTAVariableSet.builder();
						return newVariableSet;
					});
		}
		
		@Override
		@RosettaAttribute("ratedParty")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("ratedParty")
		public MTARatedPartyEnum getRatedParty() {
			return ratedParty;
		}
		
		@Override
		@RosettaAttribute("namedEntity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("namedEntity")
		public String getNamedEntity() {
			return namedEntity;
		}
		
		@Override
		@RosettaAttribute("namedAffiliate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("namedAffiliate")
		public String getNamedAffiliate() {
			return namedAffiliate;
		}
		
		@Override
		@RosettaAttribute("compare")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compare")
		public CreditNotationMismatchResolutionEnum getCompare() {
			return compare;
		}
		
		@Override
		@RosettaAttribute("noRating")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("noRating")
		public Boolean getNoRating() {
			return noRating;
		}
		
		@Override
		@RosettaAttribute("notRatedBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("notRatedBy")
		public NotRatedByEnum getNotRatedBy() {
			return notRatedBy;
		}
		
		@Override
		@RosettaAttribute("numberOfRatingAgencies")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("numberOfRatingAgencies")
		public NumberOfRatingAgenciesEnum getNumberOfRatingAgencies() {
			return numberOfRatingAgencies;
		}
		
		@Override
		@RosettaAttribute("zeroEvent")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("zeroEvent")
		public Boolean getZeroEvent() {
			return zeroEvent;
		}
		
		@Override
		@RosettaAttribute("event")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("event")
		public List<MTAZeroEventEnum> getEvent() {
			return event;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("party")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setParty(CounterpartyRoleEnum _party) {
			this.party = _party == null ? null : _party;
			return this;
		}
		
		@RosettaAttribute("currency")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("currency")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setCurrency(ISOCurrencyCodeEnum _currency) {
			this.currency = _currency == null ? null : _currency;
			return this;
		}
		
		@RosettaAttribute("ratingType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("ratingType")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setRatingType(RatingTypeEnum _ratingType) {
			this.ratingType = _ratingType == null ? null : _ratingType;
			return this;
		}
		
		@RosettaAttribute("variableSet")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("variableSet")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder addVariableSet(CSAMTAVariableSet _variableSet) {
			if (_variableSet != null) {
				this.variableSet.add(_variableSet.toBuilder());
			}
			return this;
		}
		
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder addVariableSet(CSAMTAVariableSet _variableSet, int idx) {
			getIndex(this.variableSet, idx, () -> _variableSet.toBuilder());
			return this;
		}
		
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder addVariableSet(List<? extends CSAMTAVariableSet> variableSets) {
			if (variableSets != null) {
				for (final CSAMTAVariableSet toAdd : variableSets) {
					this.variableSet.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("variableSet")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("variableSet")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setVariableSet(List<? extends CSAMTAVariableSet> variableSets) {
			if (variableSets == null) {
				this.variableSet = new ArrayList<>();
			} else {
				this.variableSet = variableSets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("ratedParty")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("ratedParty")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setRatedParty(MTARatedPartyEnum _ratedParty) {
			this.ratedParty = _ratedParty == null ? null : _ratedParty;
			return this;
		}
		
		@RosettaAttribute("namedEntity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("namedEntity")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setNamedEntity(String _namedEntity) {
			this.namedEntity = _namedEntity == null ? null : _namedEntity;
			return this;
		}
		
		@RosettaAttribute("namedAffiliate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("namedAffiliate")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setNamedAffiliate(String _namedAffiliate) {
			this.namedAffiliate = _namedAffiliate == null ? null : _namedAffiliate;
			return this;
		}
		
		@RosettaAttribute("compare")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compare")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setCompare(CreditNotationMismatchResolutionEnum _compare) {
			this.compare = _compare == null ? null : _compare;
			return this;
		}
		
		@RosettaAttribute("noRating")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("noRating")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setNoRating(Boolean _noRating) {
			this.noRating = _noRating == null ? null : _noRating;
			return this;
		}
		
		@RosettaAttribute("notRatedBy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("notRatedBy")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setNotRatedBy(NotRatedByEnum _notRatedBy) {
			this.notRatedBy = _notRatedBy == null ? null : _notRatedBy;
			return this;
		}
		
		@RosettaAttribute("numberOfRatingAgencies")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("numberOfRatingAgencies")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setNumberOfRatingAgencies(NumberOfRatingAgenciesEnum _numberOfRatingAgencies) {
			this.numberOfRatingAgencies = _numberOfRatingAgencies == null ? null : _numberOfRatingAgencies;
			return this;
		}
		
		@RosettaAttribute("zeroEvent")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("zeroEvent")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setZeroEvent(Boolean _zeroEvent) {
			this.zeroEvent = _zeroEvent == null ? null : _zeroEvent;
			return this;
		}
		
		@RosettaAttribute("event")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("event")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder addEvent(MTAZeroEventEnum _event) {
			if (_event != null) {
				this.event.add(_event);
			}
			return this;
		}
		
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder addEvent(MTAZeroEventEnum _event, int idx) {
			getIndex(this.event, idx, () -> _event);
			return this;
		}
		
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder addEvent(List<MTAZeroEventEnum> events) {
			if (events != null) {
				for (final MTAZeroEventEnum toAdd : events) {
					this.event.add(toAdd);
				}
			}
			return this;
		}
		
		@RosettaAttribute("event")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("event")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder setEvent(List<MTAZeroEventEnum> events) {
			if (events == null) {
				this.event = new ArrayList<>();
			} else {
				this.event = events.stream()
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MTARatingsBased build() {
			return new MTARatingsBased.MTARatingsBasedImpl(this);
		}
		
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder prune() {
			variableSet = variableSet.stream().filter(b->b!=null).<CSAMTAVariableSet.CSAMTAVariableSetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getParty()!=null) return true;
			if (getCurrency()!=null) return true;
			if (getRatingType()!=null) return true;
			if (getVariableSet()!=null && getVariableSet().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getRatedParty()!=null) return true;
			if (getNamedEntity()!=null) return true;
			if (getNamedAffiliate()!=null) return true;
			if (getCompare()!=null) return true;
			if (getNoRating()!=null) return true;
			if (getNotRatedBy()!=null) return true;
			if (getNumberOfRatingAgencies()!=null) return true;
			if (getZeroEvent()!=null) return true;
			if (getEvent()!=null && !getEvent().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MTARatingsBased.MTARatingsBasedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MTARatingsBased.MTARatingsBasedBuilder o = (MTARatingsBased.MTARatingsBasedBuilder) other;
			
			merger.mergeRosetta(getVariableSet(), o.getVariableSet(), this::getOrCreateVariableSet);
			
			merger.mergeBasic(getParty(), o.getParty(), this::setParty);
			merger.mergeBasic(getCurrency(), o.getCurrency(), this::setCurrency);
			merger.mergeBasic(getRatingType(), o.getRatingType(), this::setRatingType);
			merger.mergeBasic(getRatedParty(), o.getRatedParty(), this::setRatedParty);
			merger.mergeBasic(getNamedEntity(), o.getNamedEntity(), this::setNamedEntity);
			merger.mergeBasic(getNamedAffiliate(), o.getNamedAffiliate(), this::setNamedAffiliate);
			merger.mergeBasic(getCompare(), o.getCompare(), this::setCompare);
			merger.mergeBasic(getNoRating(), o.getNoRating(), this::setNoRating);
			merger.mergeBasic(getNotRatedBy(), o.getNotRatedBy(), this::setNotRatedBy);
			merger.mergeBasic(getNumberOfRatingAgencies(), o.getNumberOfRatingAgencies(), this::setNumberOfRatingAgencies);
			merger.mergeBasic(getZeroEvent(), o.getZeroEvent(), this::setZeroEvent);
			merger.mergeBasic(getEvent(), o.getEvent(), (Consumer<MTAZeroEventEnum>) this::addEvent);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MTARatingsBased _that = getType().cast(o);
		
			if (!Objects.equals(party, _that.getParty())) return false;
			if (!Objects.equals(currency, _that.getCurrency())) return false;
			if (!Objects.equals(ratingType, _that.getRatingType())) return false;
			if (!ListEquals.listEquals(variableSet, _that.getVariableSet())) return false;
			if (!Objects.equals(ratedParty, _that.getRatedParty())) return false;
			if (!Objects.equals(namedEntity, _that.getNamedEntity())) return false;
			if (!Objects.equals(namedAffiliate, _that.getNamedAffiliate())) return false;
			if (!Objects.equals(compare, _that.getCompare())) return false;
			if (!Objects.equals(noRating, _that.getNoRating())) return false;
			if (!Objects.equals(notRatedBy, _that.getNotRatedBy())) return false;
			if (!Objects.equals(numberOfRatingAgencies, _that.getNumberOfRatingAgencies())) return false;
			if (!Objects.equals(zeroEvent, _that.getZeroEvent())) return false;
			if (!ListEquals.listEquals(event, _that.getEvent())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (party != null ? party.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (currency != null ? currency.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (ratingType != null ? ratingType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (variableSet != null ? variableSet.hashCode() : 0);
			_result = 31 * _result + (ratedParty != null ? ratedParty.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (namedEntity != null ? namedEntity.hashCode() : 0);
			_result = 31 * _result + (namedAffiliate != null ? namedAffiliate.hashCode() : 0);
			_result = 31 * _result + (compare != null ? compare.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (noRating != null ? noRating.hashCode() : 0);
			_result = 31 * _result + (notRatedBy != null ? notRatedBy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (numberOfRatingAgencies != null ? numberOfRatingAgencies.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (zeroEvent != null ? zeroEvent.hashCode() : 0);
			_result = 31 * _result + (event != null ? event.stream().map(Object::getClass).map(Class::getName).mapToInt(String::hashCode).sum() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MTARatingsBasedBuilder {" +
				"party=" + this.party + ", " +
				"currency=" + this.currency + ", " +
				"ratingType=" + this.ratingType + ", " +
				"variableSet=" + this.variableSet + ", " +
				"ratedParty=" + this.ratedParty + ", " +
				"namedEntity=" + this.namedEntity + ", " +
				"namedAffiliate=" + this.namedAffiliate + ", " +
				"compare=" + this.compare + ", " +
				"noRating=" + this.noRating + ", " +
				"notRatedBy=" + this.notRatedBy + ", " +
				"numberOfRatingAgencies=" + this.numberOfRatingAgencies + ", " +
				"zeroEvent=" + this.zeroEvent + ", " +
				"event=" + this.event +
			'}';
		}
	}
}
