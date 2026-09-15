package fpml.consolidated.loan;

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
import fpml.consolidated.business.events.BusinessEventIdentifier;
import fpml.consolidated.loan.meta.LoanAllocationSettlementDateAvailabilityMeta;
import fpml.consolidated.shared.DateList;
import fpml.consolidated.shared.PartyReference;
import java.time.LocalTime;
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
 * version "confirmation-5.13"
 *
 * Provision An event structure defining information related to trade settlement date coordination.
 *
 */
@RosettaDataType(value="LoanAllocationSettlementDateAvailability", builder=LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LoanAllocationSettlementDateAvailability", model="fpml", builder=LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilderImpl.class, version="2.1.1")
public interface LoanAllocationSettlementDateAvailability extends AbstractLoanAllocationEvent {

	LoanAllocationSettlementDateAvailabilityMeta metaData = new LoanAllocationSettlementDateAvailabilityMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specific date or dates on which a trade may be settled.
	 *
	 */
	DateList getSpecificDates();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period begins.
	 *
	 */
	ZonedDateTime getStartDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on which this period ends.
	 *
	 */
	ZonedDateTime getEndDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Date on or after which a trade can be settled.
	 *
	 */
	ZonedDateTime getOnOrAfterDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Number of days advance notification required to express the intent to settle a trade.
	 *
	 */
	Integer getLeadDays();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Specific cutoff time to express the intent to settle a trade.
	 *
	 */
	LocalTime getCutOffTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A period during which no settlement of a trade can occur, other than non-business days.
	 *
	 */
	List<? extends LoanAllocationNoSettlePeriod> getNoSettlePeriod();

	/*********************** Build Methods  ***********************/
	LoanAllocationSettlementDateAvailability build();
	
	LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder toBuilder();
	
	static LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder builder() {
		return new LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanAllocationSettlementDateAvailability> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LoanAllocationSettlementDateAvailability> getType() {
		return LoanAllocationSettlementDateAvailability.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.class, getEventIdentifier());
		processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.class, getParentEventIdentifier());
		processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.class, getPreviousEventIdentifier());
		processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.class, getCorrectedEventIdentifier());
		processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.class, getLenderPartyReference());
		processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.class, getCashPayable());
		processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
		processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.class, getAllocationReference());
		processRosetta(path.newSubPath("specificDates"), processor, DateList.class, getSpecificDates());
		processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
		processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
		processor.processBasic(path.newSubPath("onOrAfterDate"), ZonedDateTime.class, getOnOrAfterDate(), this);
		processor.processBasic(path.newSubPath("leadDays"), Integer.class, getLeadDays(), this);
		processor.processBasic(path.newSubPath("cutOffTime"), LocalTime.class, getCutOffTime(), this);
		processRosetta(path.newSubPath("noSettlePeriod"), processor, LoanAllocationNoSettlePeriod.class, getNoSettlePeriod());
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanAllocationSettlementDateAvailabilityBuilder extends LoanAllocationSettlementDateAvailability, AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilder {
		DateList.DateListBuilder getOrCreateSpecificDates();
		@Override
		DateList.DateListBuilder getSpecificDates();
		LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder getOrCreateNoSettlePeriod(int index);
		@Override
		List<? extends LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder> getNoSettlePeriod();
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addEventIdentifier(BusinessEventIdentifier eventIdentifier, int idx);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifier);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setParentEventIdentifier(ParentEventIdentifier parentEventIdentifier);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setPreviousEventIdentifier(BusinessEventIdentifier previousEventIdentifier);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setCorrectedEventIdentifier(BusinessEventIdentifier correctedEventIdentifier);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setLenderPartyReference(PartyReference lenderPartyReference);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setCashPayable(CashPayable cashPayable);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setComment(String comment);
		@Override
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setAllocationReference(LoanAllocationReference allocationReference);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setSpecificDates(DateList specificDates);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setStartDate(ZonedDateTime startDate);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setEndDate(ZonedDateTime endDate);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setOnOrAfterDate(ZonedDateTime onOrAfterDate);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setLeadDays(Integer leadDays);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setCutOffTime(LocalTime cutOffTime);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addNoSettlePeriod(LoanAllocationNoSettlePeriod noSettlePeriod);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addNoSettlePeriod(LoanAllocationNoSettlePeriod noSettlePeriod, int idx);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addNoSettlePeriod(List<? extends LoanAllocationNoSettlePeriod> noSettlePeriod);
		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setNoSettlePeriod(List<? extends LoanAllocationNoSettlePeriod> noSettlePeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("eventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getEventIdentifier());
			processRosetta(path.newSubPath("parentEventIdentifier"), processor, ParentEventIdentifier.ParentEventIdentifierBuilder.class, getParentEventIdentifier());
			processRosetta(path.newSubPath("previousEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getPreviousEventIdentifier());
			processRosetta(path.newSubPath("correctedEventIdentifier"), processor, BusinessEventIdentifier.BusinessEventIdentifierBuilder.class, getCorrectedEventIdentifier());
			processRosetta(path.newSubPath("lenderPartyReference"), processor, PartyReference.PartyReferenceBuilder.class, getLenderPartyReference());
			processRosetta(path.newSubPath("cashPayable"), processor, CashPayable.CashPayableBuilder.class, getCashPayable());
			processor.processBasic(path.newSubPath("comment"), String.class, getComment(), this);
			processRosetta(path.newSubPath("allocationReference"), processor, LoanAllocationReference.LoanAllocationReferenceBuilder.class, getAllocationReference());
			processRosetta(path.newSubPath("specificDates"), processor, DateList.DateListBuilder.class, getSpecificDates());
			processor.processBasic(path.newSubPath("startDate"), ZonedDateTime.class, getStartDate(), this);
			processor.processBasic(path.newSubPath("endDate"), ZonedDateTime.class, getEndDate(), this);
			processor.processBasic(path.newSubPath("onOrAfterDate"), ZonedDateTime.class, getOnOrAfterDate(), this);
			processor.processBasic(path.newSubPath("leadDays"), Integer.class, getLeadDays(), this);
			processor.processBasic(path.newSubPath("cutOffTime"), LocalTime.class, getCutOffTime(), this);
			processRosetta(path.newSubPath("noSettlePeriod"), processor, LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder.class, getNoSettlePeriod());
		}
		

		LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder prune();
	}

	/*********************** Immutable Implementation of LoanAllocationSettlementDateAvailability  ***********************/
	class LoanAllocationSettlementDateAvailabilityImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventImpl implements LoanAllocationSettlementDateAvailability {
		private final DateList specificDates;
		private final ZonedDateTime startDate;
		private final ZonedDateTime endDate;
		private final ZonedDateTime onOrAfterDate;
		private final Integer leadDays;
		private final LocalTime cutOffTime;
		private final List<? extends LoanAllocationNoSettlePeriod> noSettlePeriod;
		
		protected LoanAllocationSettlementDateAvailabilityImpl(LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder builder) {
			super(builder);
			this.specificDates = ofNullable(builder.getSpecificDates()).map(f->f.build()).orElse(null);
			this.startDate = builder.getStartDate();
			this.endDate = builder.getEndDate();
			this.onOrAfterDate = builder.getOnOrAfterDate();
			this.leadDays = builder.getLeadDays();
			this.cutOffTime = builder.getCutOffTime();
			this.noSettlePeriod = ofNullable(builder.getNoSettlePeriod()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("specificDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificDates")
		public DateList getSpecificDates() {
			return specificDates;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("onOrAfterDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("onOrAfterDate")
		public ZonedDateTime getOnOrAfterDate() {
			return onOrAfterDate;
		}
		
		@Override
		@RosettaAttribute("leadDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leadDays")
		public Integer getLeadDays() {
			return leadDays;
		}
		
		@Override
		@RosettaAttribute("cutOffTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cutOffTime")
		public LocalTime getCutOffTime() {
			return cutOffTime;
		}
		
		@Override
		@RosettaAttribute("noSettlePeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("noSettlePeriod")
		public List<? extends LoanAllocationNoSettlePeriod> getNoSettlePeriod() {
			return noSettlePeriod;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailability build() {
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder toBuilder() {
			LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getSpecificDates()).ifPresent(builder::setSpecificDates);
			ofNullable(getStartDate()).ifPresent(builder::setStartDate);
			ofNullable(getEndDate()).ifPresent(builder::setEndDate);
			ofNullable(getOnOrAfterDate()).ifPresent(builder::setOnOrAfterDate);
			ofNullable(getLeadDays()).ifPresent(builder::setLeadDays);
			ofNullable(getCutOffTime()).ifPresent(builder::setCutOffTime);
			ofNullable(getNoSettlePeriod()).ifPresent(builder::setNoSettlePeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementDateAvailability _that = getType().cast(o);
		
			if (!Objects.equals(specificDates, _that.getSpecificDates())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(onOrAfterDate, _that.getOnOrAfterDate())) return false;
			if (!Objects.equals(leadDays, _that.getLeadDays())) return false;
			if (!Objects.equals(cutOffTime, _that.getCutOffTime())) return false;
			if (!ListEquals.listEquals(noSettlePeriod, _that.getNoSettlePeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (specificDates != null ? specificDates.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (onOrAfterDate != null ? onOrAfterDate.hashCode() : 0);
			_result = 31 * _result + (leadDays != null ? leadDays.hashCode() : 0);
			_result = 31 * _result + (cutOffTime != null ? cutOffTime.hashCode() : 0);
			_result = 31 * _result + (noSettlePeriod != null ? noSettlePeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementDateAvailability {" +
				"specificDates=" + this.specificDates + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"onOrAfterDate=" + this.onOrAfterDate + ", " +
				"leadDays=" + this.leadDays + ", " +
				"cutOffTime=" + this.cutOffTime + ", " +
				"noSettlePeriod=" + this.noSettlePeriod +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of LoanAllocationSettlementDateAvailability  ***********************/
	class LoanAllocationSettlementDateAvailabilityBuilderImpl extends AbstractLoanAllocationEvent.AbstractLoanAllocationEventBuilderImpl implements LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder {
	
		protected DateList.DateListBuilder specificDates;
		protected ZonedDateTime startDate;
		protected ZonedDateTime endDate;
		protected ZonedDateTime onOrAfterDate;
		protected Integer leadDays;
		protected LocalTime cutOffTime;
		protected List<LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder> noSettlePeriod = new ArrayList<>();
		
		@Override
		@RosettaAttribute("specificDates")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("specificDates")
		public DateList.DateListBuilder getSpecificDates() {
			return specificDates;
		}
		
		@Override
		public DateList.DateListBuilder getOrCreateSpecificDates() {
			DateList.DateListBuilder result;
			if (specificDates!=null) {
				result = specificDates;
			}
			else {
				result = specificDates = DateList.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("startDate")
		public ZonedDateTime getStartDate() {
			return startDate;
		}
		
		@Override
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("endDate")
		public ZonedDateTime getEndDate() {
			return endDate;
		}
		
		@Override
		@RosettaAttribute("onOrAfterDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("onOrAfterDate")
		public ZonedDateTime getOnOrAfterDate() {
			return onOrAfterDate;
		}
		
		@Override
		@RosettaAttribute("leadDays")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("leadDays")
		public Integer getLeadDays() {
			return leadDays;
		}
		
		@Override
		@RosettaAttribute("cutOffTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("cutOffTime")
		public LocalTime getCutOffTime() {
			return cutOffTime;
		}
		
		@Override
		@RosettaAttribute("noSettlePeriod")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("noSettlePeriod")
		public List<? extends LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder> getNoSettlePeriod() {
			return noSettlePeriod;
		}
		
		@Override
		public LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder getOrCreateNoSettlePeriod(int index) {
			if (noSettlePeriod==null) {
				this.noSettlePeriod = new ArrayList<>();
			}
			return getIndex(noSettlePeriod, index, () -> {
						LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder newNoSettlePeriod = LoanAllocationNoSettlePeriod.builder();
						return newNoSettlePeriod;
					});
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addEventIdentifier(BusinessEventIdentifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final BusinessEventIdentifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setEventIdentifier(List<? extends BusinessEventIdentifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentEventIdentifier")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setParentEventIdentifier(ParentEventIdentifier _parentEventIdentifier) {
			this.parentEventIdentifier = _parentEventIdentifier == null ? null : _parentEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("previousEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("previousEventIdentifier")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setPreviousEventIdentifier(BusinessEventIdentifier _previousEventIdentifier) {
			this.previousEventIdentifier = _previousEventIdentifier == null ? null : _previousEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correctedEventIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("correctedEventIdentifier")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setCorrectedEventIdentifier(BusinessEventIdentifier _correctedEventIdentifier) {
			this.correctedEventIdentifier = _correctedEventIdentifier == null ? null : _correctedEventIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("lenderPartyReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("lenderPartyReference")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setLenderPartyReference(PartyReference _lenderPartyReference) {
			this.lenderPartyReference = _lenderPartyReference == null ? null : _lenderPartyReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("cashPayable")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cashPayable")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setCashPayable(CashPayable _cashPayable) {
			this.cashPayable = _cashPayable == null ? null : _cashPayable.toBuilder();
			return this;
		}
		
		@RosettaAttribute("comment")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("comment")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setComment(String _comment) {
			this.comment = _comment == null ? null : _comment;
			return this;
		}
		
		@RosettaAttribute("allocationReference")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("allocationReference")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setAllocationReference(LoanAllocationReference _allocationReference) {
			this.allocationReference = _allocationReference == null ? null : _allocationReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("specificDates")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("specificDates")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setSpecificDates(DateList _specificDates) {
			this.specificDates = _specificDates == null ? null : _specificDates.toBuilder();
			return this;
		}
		
		@RosettaAttribute("startDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("startDate")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setStartDate(ZonedDateTime _startDate) {
			this.startDate = _startDate == null ? null : _startDate;
			return this;
		}
		
		@RosettaAttribute("endDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("endDate")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setEndDate(ZonedDateTime _endDate) {
			this.endDate = _endDate == null ? null : _endDate;
			return this;
		}
		
		@RosettaAttribute("onOrAfterDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("onOrAfterDate")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setOnOrAfterDate(ZonedDateTime _onOrAfterDate) {
			this.onOrAfterDate = _onOrAfterDate == null ? null : _onOrAfterDate;
			return this;
		}
		
		@RosettaAttribute("leadDays")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("leadDays")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setLeadDays(Integer _leadDays) {
			this.leadDays = _leadDays == null ? null : _leadDays;
			return this;
		}
		
		@RosettaAttribute("cutOffTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("cutOffTime")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setCutOffTime(LocalTime _cutOffTime) {
			this.cutOffTime = _cutOffTime == null ? null : _cutOffTime;
			return this;
		}
		
		@RosettaAttribute("noSettlePeriod")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("noSettlePeriod")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addNoSettlePeriod(LoanAllocationNoSettlePeriod _noSettlePeriod) {
			if (_noSettlePeriod != null) {
				this.noSettlePeriod.add(_noSettlePeriod.toBuilder());
			}
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addNoSettlePeriod(LoanAllocationNoSettlePeriod _noSettlePeriod, int idx) {
			getIndex(this.noSettlePeriod, idx, () -> _noSettlePeriod.toBuilder());
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder addNoSettlePeriod(List<? extends LoanAllocationNoSettlePeriod> noSettlePeriods) {
			if (noSettlePeriods != null) {
				for (final LoanAllocationNoSettlePeriod toAdd : noSettlePeriods) {
					this.noSettlePeriod.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("noSettlePeriod")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("noSettlePeriod")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder setNoSettlePeriod(List<? extends LoanAllocationNoSettlePeriod> noSettlePeriods) {
			if (noSettlePeriods == null) {
				this.noSettlePeriod = new ArrayList<>();
			} else {
				this.noSettlePeriod = noSettlePeriods.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public LoanAllocationSettlementDateAvailability build() {
			return new LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityImpl(this);
		}
		
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder prune() {
			super.prune();
			if (specificDates!=null && !specificDates.prune().hasData()) specificDates = null;
			noSettlePeriod = noSettlePeriod.stream().filter(b->b!=null).<LoanAllocationNoSettlePeriod.LoanAllocationNoSettlePeriodBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getSpecificDates()!=null && getSpecificDates().hasData()) return true;
			if (getStartDate()!=null) return true;
			if (getEndDate()!=null) return true;
			if (getOnOrAfterDate()!=null) return true;
			if (getLeadDays()!=null) return true;
			if (getCutOffTime()!=null) return true;
			if (getNoSettlePeriod()!=null && getNoSettlePeriod().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder o = (LoanAllocationSettlementDateAvailability.LoanAllocationSettlementDateAvailabilityBuilder) other;
			
			merger.mergeRosetta(getSpecificDates(), o.getSpecificDates(), this::setSpecificDates);
			merger.mergeRosetta(getNoSettlePeriod(), o.getNoSettlePeriod(), this::getOrCreateNoSettlePeriod);
			
			merger.mergeBasic(getStartDate(), o.getStartDate(), this::setStartDate);
			merger.mergeBasic(getEndDate(), o.getEndDate(), this::setEndDate);
			merger.mergeBasic(getOnOrAfterDate(), o.getOnOrAfterDate(), this::setOnOrAfterDate);
			merger.mergeBasic(getLeadDays(), o.getLeadDays(), this::setLeadDays);
			merger.mergeBasic(getCutOffTime(), o.getCutOffTime(), this::setCutOffTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			LoanAllocationSettlementDateAvailability _that = getType().cast(o);
		
			if (!Objects.equals(specificDates, _that.getSpecificDates())) return false;
			if (!Objects.equals(startDate, _that.getStartDate())) return false;
			if (!Objects.equals(endDate, _that.getEndDate())) return false;
			if (!Objects.equals(onOrAfterDate, _that.getOnOrAfterDate())) return false;
			if (!Objects.equals(leadDays, _that.getLeadDays())) return false;
			if (!Objects.equals(cutOffTime, _that.getCutOffTime())) return false;
			if (!ListEquals.listEquals(noSettlePeriod, _that.getNoSettlePeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (specificDates != null ? specificDates.hashCode() : 0);
			_result = 31 * _result + (startDate != null ? startDate.hashCode() : 0);
			_result = 31 * _result + (endDate != null ? endDate.hashCode() : 0);
			_result = 31 * _result + (onOrAfterDate != null ? onOrAfterDate.hashCode() : 0);
			_result = 31 * _result + (leadDays != null ? leadDays.hashCode() : 0);
			_result = 31 * _result + (cutOffTime != null ? cutOffTime.hashCode() : 0);
			_result = 31 * _result + (noSettlePeriod != null ? noSettlePeriod.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanAllocationSettlementDateAvailabilityBuilder {" +
				"specificDates=" + this.specificDates + ", " +
				"startDate=" + this.startDate + ", " +
				"endDate=" + this.endDate + ", " +
				"onOrAfterDate=" + this.onOrAfterDate + ", " +
				"leadDays=" + this.leadDays + ", " +
				"cutOffTime=" + this.cutOffTime + ", " +
				"noSettlePeriod=" + this.noSettlePeriod +
			'}' + " " + super.toString();
		}
	}
}
