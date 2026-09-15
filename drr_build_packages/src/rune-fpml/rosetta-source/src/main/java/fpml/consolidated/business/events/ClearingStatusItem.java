package fpml.consolidated.business.events;

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
import fpml.consolidated.asset.BasicQuotation;
import fpml.consolidated.business.events.meta.ClearingStatusItemMeta;
import fpml.consolidated.doc.ClearingStatusValue;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.TradeIdentifier;
import fpml.consolidated.shared.PartyReference;
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
 * Provision A component of a clearing status report. This provides the clearing status for a single trade.
 *
 */
@RosettaDataType(value="ClearingStatusItem", builder=ClearingStatusItem.ClearingStatusItemBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClearingStatusItem", model="fpml", builder=ClearingStatusItem.ClearingStatusItemBuilderImpl.class, version="2.1.1")
public interface ClearingStatusItem extends RosettaModelObject {

	ClearingStatusItemMeta metaData = new ClearingStatusItemMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Identifier(s) for the trade which is the subject of the clearing request to which this status relates.
	 *
	 */
	List<? extends TradeIdentifier> getTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Information about a trade.
	 *
	 */
	TradeReferenceInformation getTradeReferenceInformation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Complete economics of the trade
	 *
	 */
	Trade getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradePackage getTradePackage();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Pricing information for the trade.
	 *
	 */
	List<? extends BasicQuotation> getQuote();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The status of the clearing process for the identified trade. For example, Received, Pending (Approval), Registered (i.e. cleared), Rejected, etc.
	 *
	 */
	ClearingStatusValue getClearingStatusValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision When the clearing status changed to the current value. This is mostly useful if the clearing status messages could be delayed from when the status actually changes; this could be important if the status date is used as the basis of any settlement calculations.
	 *
	 */
	ZonedDateTime getUpdatedDateTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Supporting information which may be produced to explain the clearing process status. This may be a business reason e.g. failed eligibility criteria for a trade in Rejected status.
	 *
	 */
	List<? extends Reason> getReason();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Reference to parties currently in this status, e.g. parties for which we are awaiting approval. For example, if a trade is in "Pending" status, this would identify which parties' approval the trade was pending.
	 *
	 */
	List<? extends PartyReference> getStatusAppliesTo();

	/*********************** Build Methods  ***********************/
	ClearingStatusItem build();
	
	ClearingStatusItem.ClearingStatusItemBuilder toBuilder();
	
	static ClearingStatusItem.ClearingStatusItemBuilder builder() {
		return new ClearingStatusItem.ClearingStatusItemBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingStatusItem> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingStatusItem> getType() {
		return ClearingStatusItem.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.class, getTradeIdentifier());
		processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.class, getTradeReferenceInformation());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.class, getTradePackage());
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
		processRosetta(path.newSubPath("clearingStatusValue"), processor, ClearingStatusValue.class, getClearingStatusValue());
		processor.processBasic(path.newSubPath("updatedDateTime"), ZonedDateTime.class, getUpdatedDateTime(), this);
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
		processRosetta(path.newSubPath("statusAppliesTo"), processor, PartyReference.class, getStatusAppliesTo());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingStatusItemBuilder extends ClearingStatusItem, RosettaModelObjectBuilder {
		TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int index);
		@Override
		List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier();
		TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation();
		@Override
		TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation();
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		TradePackage.TradePackageBuilder getOrCreateTradePackage();
		@Override
		TradePackage.TradePackageBuilder getTradePackage();
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index);
		@Override
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatusValue();
		@Override
		ClearingStatusValue.ClearingStatusValueBuilder getClearingStatusValue();
		Reason.ReasonBuilder getOrCreateReason(int index);
		@Override
		List<? extends Reason.ReasonBuilder> getReason();
		PartyReference.PartyReferenceBuilder getOrCreateStatusAppliesTo(int index);
		@Override
		List<? extends PartyReference.PartyReferenceBuilder> getStatusAppliesTo();
		ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier);
		ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(TradeIdentifier tradeIdentifier, int idx);
		ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier);
		ClearingStatusItem.ClearingStatusItemBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifier);
		ClearingStatusItem.ClearingStatusItemBuilder setTradeReferenceInformation(TradeReferenceInformation tradeReferenceInformation);
		ClearingStatusItem.ClearingStatusItemBuilder setTrade(Trade trade);
		ClearingStatusItem.ClearingStatusItemBuilder setTradePackage(TradePackage tradePackage);
		ClearingStatusItem.ClearingStatusItemBuilder addQuote(BasicQuotation quote);
		ClearingStatusItem.ClearingStatusItemBuilder addQuote(BasicQuotation quote, int idx);
		ClearingStatusItem.ClearingStatusItemBuilder addQuote(List<? extends BasicQuotation> quote);
		ClearingStatusItem.ClearingStatusItemBuilder setQuote(List<? extends BasicQuotation> quote);
		ClearingStatusItem.ClearingStatusItemBuilder setClearingStatusValue(ClearingStatusValue clearingStatusValue);
		ClearingStatusItem.ClearingStatusItemBuilder setUpdatedDateTime(ZonedDateTime updatedDateTime);
		ClearingStatusItem.ClearingStatusItemBuilder addReason(Reason reason);
		ClearingStatusItem.ClearingStatusItemBuilder addReason(Reason reason, int idx);
		ClearingStatusItem.ClearingStatusItemBuilder addReason(List<? extends Reason> reason);
		ClearingStatusItem.ClearingStatusItemBuilder setReason(List<? extends Reason> reason);
		ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(PartyReference statusAppliesTo);
		ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(PartyReference statusAppliesTo, int idx);
		ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(List<? extends PartyReference> statusAppliesTo);
		ClearingStatusItem.ClearingStatusItemBuilder setStatusAppliesTo(List<? extends PartyReference> statusAppliesTo);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("tradeIdentifier"), processor, TradeIdentifier.TradeIdentifierBuilder.class, getTradeIdentifier());
			processRosetta(path.newSubPath("tradeReferenceInformation"), processor, TradeReferenceInformation.TradeReferenceInformationBuilder.class, getTradeReferenceInformation());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.TradePackageBuilder.class, getTradePackage());
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
			processRosetta(path.newSubPath("clearingStatusValue"), processor, ClearingStatusValue.ClearingStatusValueBuilder.class, getClearingStatusValue());
			processor.processBasic(path.newSubPath("updatedDateTime"), ZonedDateTime.class, getUpdatedDateTime(), this);
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("statusAppliesTo"), processor, PartyReference.PartyReferenceBuilder.class, getStatusAppliesTo());
		}
		

		ClearingStatusItem.ClearingStatusItemBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingStatusItem  ***********************/
	class ClearingStatusItemImpl implements ClearingStatusItem {
		private final List<? extends TradeIdentifier> tradeIdentifier;
		private final TradeReferenceInformation tradeReferenceInformation;
		private final Trade trade;
		private final TradePackage tradePackage;
		private final List<? extends BasicQuotation> quote;
		private final ClearingStatusValue clearingStatusValue;
		private final ZonedDateTime updatedDateTime;
		private final List<? extends Reason> reason;
		private final List<? extends PartyReference> statusAppliesTo;
		
		protected ClearingStatusItemImpl(ClearingStatusItem.ClearingStatusItemBuilder builder) {
			this.tradeIdentifier = ofNullable(builder.getTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeReferenceInformation = ofNullable(builder.getTradeReferenceInformation()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.tradePackage = ofNullable(builder.getTradePackage()).map(f->f.build()).orElse(null);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.clearingStatusValue = ofNullable(builder.getClearingStatusValue()).map(f->f.build()).orElse(null);
			this.updatedDateTime = builder.getUpdatedDateTime();
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.statusAppliesTo = ofNullable(builder.getStatusAppliesTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeReferenceInformation")
		public TradeReferenceInformation getTradeReferenceInformation() {
			return tradeReferenceInformation;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePackage")
		public TradePackage getTradePackage() {
			return tradePackage;
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation> getQuote() {
			return quote;
		}
		
		@Override
		@RosettaAttribute("clearingStatusValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("clearingStatusValue")
		public ClearingStatusValue getClearingStatusValue() {
			return clearingStatusValue;
		}
		
		@Override
		@RosettaAttribute("updatedDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("updatedDateTime")
		public ZonedDateTime getUpdatedDateTime() {
			return updatedDateTime;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("statusAppliesTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("statusAppliesTo")
		public List<? extends PartyReference> getStatusAppliesTo() {
			return statusAppliesTo;
		}
		
		@Override
		public ClearingStatusItem build() {
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder toBuilder() {
			ClearingStatusItem.ClearingStatusItemBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingStatusItem.ClearingStatusItemBuilder builder) {
			ofNullable(getTradeIdentifier()).ifPresent(builder::setTradeIdentifier);
			ofNullable(getTradeReferenceInformation()).ifPresent(builder::setTradeReferenceInformation);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getTradePackage()).ifPresent(builder::setTradePackage);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
			ofNullable(getClearingStatusValue()).ifPresent(builder::setClearingStatusValue);
			ofNullable(getUpdatedDateTime()).ifPresent(builder::setUpdatedDateTime);
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getStatusAppliesTo()).ifPresent(builder::setStatusAppliesTo);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingStatusItem _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!Objects.equals(clearingStatusValue, _that.getClearingStatusValue())) return false;
			if (!Objects.equals(updatedDateTime, _that.getUpdatedDateTime())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(statusAppliesTo, _that.getStatusAppliesTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (clearingStatusValue != null ? clearingStatusValue.hashCode() : 0);
			_result = 31 * _result + (updatedDateTime != null ? updatedDateTime.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (statusAppliesTo != null ? statusAppliesTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatusItem {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"tradeReferenceInformation=" + this.tradeReferenceInformation + ", " +
				"trade=" + this.trade + ", " +
				"tradePackage=" + this.tradePackage + ", " +
				"quote=" + this.quote + ", " +
				"clearingStatusValue=" + this.clearingStatusValue + ", " +
				"updatedDateTime=" + this.updatedDateTime + ", " +
				"reason=" + this.reason + ", " +
				"statusAppliesTo=" + this.statusAppliesTo +
			'}';
		}
	}

	/*********************** Builder Implementation of ClearingStatusItem  ***********************/
	class ClearingStatusItemBuilderImpl implements ClearingStatusItem.ClearingStatusItemBuilder {
	
		protected List<TradeIdentifier.TradeIdentifierBuilder> tradeIdentifier = new ArrayList<>();
		protected TradeReferenceInformation.TradeReferenceInformationBuilder tradeReferenceInformation;
		protected Trade.TradeBuilder trade;
		protected TradePackage.TradePackageBuilder tradePackage;
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
		protected ClearingStatusValue.ClearingStatusValueBuilder clearingStatusValue;
		protected ZonedDateTime updatedDateTime;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		protected List<PartyReference.PartyReferenceBuilder> statusAppliesTo = new ArrayList<>();
		
		@Override
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		public List<? extends TradeIdentifier.TradeIdentifierBuilder> getTradeIdentifier() {
			return tradeIdentifier;
		}
		
		@Override
		public TradeIdentifier.TradeIdentifierBuilder getOrCreateTradeIdentifier(int index) {
			if (tradeIdentifier==null) {
				this.tradeIdentifier = new ArrayList<>();
			}
			return getIndex(tradeIdentifier, index, () -> {
						TradeIdentifier.TradeIdentifierBuilder newTradeIdentifier = TradeIdentifier.builder();
						return newTradeIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradeReferenceInformation")
		public TradeReferenceInformation.TradeReferenceInformationBuilder getTradeReferenceInformation() {
			return tradeReferenceInformation;
		}
		
		@Override
		public TradeReferenceInformation.TradeReferenceInformationBuilder getOrCreateTradeReferenceInformation() {
			TradeReferenceInformation.TradeReferenceInformationBuilder result;
			if (tradeReferenceInformation!=null) {
				result = tradeReferenceInformation;
			}
			else {
				result = tradeReferenceInformation = TradeReferenceInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade.TradeBuilder getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade() {
			Trade.TradeBuilder result;
			if (trade!=null) {
				result = trade;
			}
			else {
				result = trade = Trade.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePackage")
		public TradePackage.TradePackageBuilder getTradePackage() {
			return tradePackage;
		}
		
		@Override
		public TradePackage.TradePackageBuilder getOrCreateTradePackage() {
			TradePackage.TradePackageBuilder result;
			if (tradePackage!=null) {
				result = tradePackage;
			}
			else {
				result = tradePackage = TradePackage.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("quote")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("quote")
		public List<? extends BasicQuotation.BasicQuotationBuilder> getQuote() {
			return quote;
		}
		
		@Override
		public BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index) {
			if (quote==null) {
				this.quote = new ArrayList<>();
			}
			return getIndex(quote, index, () -> {
						BasicQuotation.BasicQuotationBuilder newQuote = BasicQuotation.builder();
						return newQuote;
					});
		}
		
		@Override
		@RosettaAttribute("clearingStatusValue")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("clearingStatusValue")
		public ClearingStatusValue.ClearingStatusValueBuilder getClearingStatusValue() {
			return clearingStatusValue;
		}
		
		@Override
		public ClearingStatusValue.ClearingStatusValueBuilder getOrCreateClearingStatusValue() {
			ClearingStatusValue.ClearingStatusValueBuilder result;
			if (clearingStatusValue!=null) {
				result = clearingStatusValue;
			}
			else {
				result = clearingStatusValue = ClearingStatusValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("updatedDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("updatedDateTime")
		public ZonedDateTime getUpdatedDateTime() {
			return updatedDateTime;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public Reason.ReasonBuilder getOrCreateReason(int index) {
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			return getIndex(reason, index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("statusAppliesTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("statusAppliesTo")
		public List<? extends PartyReference.PartyReferenceBuilder> getStatusAppliesTo() {
			return statusAppliesTo;
		}
		
		@Override
		public PartyReference.PartyReferenceBuilder getOrCreateStatusAppliesTo(int index) {
			if (statusAppliesTo==null) {
				this.statusAppliesTo = new ArrayList<>();
			}
			return getIndex(statusAppliesTo, index, () -> {
						PartyReference.PartyReferenceBuilder newStatusAppliesTo = PartyReference.builder();
						return newStatusAppliesTo;
					});
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(TradeIdentifier _tradeIdentifier) {
			if (_tradeIdentifier != null) {
				this.tradeIdentifier.add(_tradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(TradeIdentifier _tradeIdentifier, int idx) {
			getIndex(this.tradeIdentifier, idx, () -> _tradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers != null) {
				for (final TradeIdentifier toAdd : tradeIdentifiers) {
					this.tradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeIdentifier")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder setTradeIdentifier(List<? extends TradeIdentifier> tradeIdentifiers) {
			if (tradeIdentifiers == null) {
				this.tradeIdentifier = new ArrayList<>();
			} else {
				this.tradeIdentifier = tradeIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeReferenceInformation")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradeReferenceInformation")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder setTradeReferenceInformation(TradeReferenceInformation _tradeReferenceInformation) {
			this.tradeReferenceInformation = _tradeReferenceInformation == null ? null : _tradeReferenceInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePackage")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder setTradePackage(TradePackage _tradePackage) {
			this.tradePackage = _tradePackage == null ? null : _tradePackage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addQuote(BasicQuotation _quote) {
			if (_quote != null) {
				this.quote.add(_quote.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addQuote(BasicQuotation _quote, int idx) {
			getIndex(this.quote, idx, () -> _quote.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addQuote(List<? extends BasicQuotation> quotes) {
			if (quotes != null) {
				for (final BasicQuotation toAdd : quotes) {
					this.quote.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null) {
				this.quote = new ArrayList<>();
			} else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("clearingStatusValue")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("clearingStatusValue")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder setClearingStatusValue(ClearingStatusValue _clearingStatusValue) {
			this.clearingStatusValue = _clearingStatusValue == null ? null : _clearingStatusValue.toBuilder();
			return this;
		}
		
		@RosettaAttribute("updatedDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("updatedDateTime")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder setUpdatedDateTime(ZonedDateTime _updatedDateTime) {
			this.updatedDateTime = _updatedDateTime == null ? null : _updatedDateTime;
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (final Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("statusAppliesTo")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("statusAppliesTo")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(PartyReference _statusAppliesTo) {
			if (_statusAppliesTo != null) {
				this.statusAppliesTo.add(_statusAppliesTo.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(PartyReference _statusAppliesTo, int idx) {
			getIndex(this.statusAppliesTo, idx, () -> _statusAppliesTo.toBuilder());
			return this;
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder addStatusAppliesTo(List<? extends PartyReference> statusAppliesTos) {
			if (statusAppliesTos != null) {
				for (final PartyReference toAdd : statusAppliesTos) {
					this.statusAppliesTo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("statusAppliesTo")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("statusAppliesTo")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder setStatusAppliesTo(List<? extends PartyReference> statusAppliesTos) {
			if (statusAppliesTos == null) {
				this.statusAppliesTo = new ArrayList<>();
			} else {
				this.statusAppliesTo = statusAppliesTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ClearingStatusItem build() {
			return new ClearingStatusItem.ClearingStatusItemImpl(this);
		}
		
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder prune() {
			tradeIdentifier = tradeIdentifier.stream().filter(b->b!=null).<TradeIdentifier.TradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (tradeReferenceInformation!=null && !tradeReferenceInformation.prune().hasData()) tradeReferenceInformation = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (tradePackage!=null && !tradePackage.prune().hasData()) tradePackage = null;
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (clearingStatusValue!=null && !clearingStatusValue.prune().hasData()) clearingStatusValue = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			statusAppliesTo = statusAppliesTo.stream().filter(b->b!=null).<PartyReference.PartyReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getTradeIdentifier()!=null && getTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeReferenceInformation()!=null && getTradeReferenceInformation().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getTradePackage()!=null && getTradePackage().hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getClearingStatusValue()!=null && getClearingStatusValue().hasData()) return true;
			if (getUpdatedDateTime()!=null) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getStatusAppliesTo()!=null && getStatusAppliesTo().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingStatusItem.ClearingStatusItemBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ClearingStatusItem.ClearingStatusItemBuilder o = (ClearingStatusItem.ClearingStatusItemBuilder) other;
			
			merger.mergeRosetta(getTradeIdentifier(), o.getTradeIdentifier(), this::getOrCreateTradeIdentifier);
			merger.mergeRosetta(getTradeReferenceInformation(), o.getTradeReferenceInformation(), this::setTradeReferenceInformation);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getTradePackage(), o.getTradePackage(), this::setTradePackage);
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			merger.mergeRosetta(getClearingStatusValue(), o.getClearingStatusValue(), this::setClearingStatusValue);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			merger.mergeRosetta(getStatusAppliesTo(), o.getStatusAppliesTo(), this::getOrCreateStatusAppliesTo);
			
			merger.mergeBasic(getUpdatedDateTime(), o.getUpdatedDateTime(), this::setUpdatedDateTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ClearingStatusItem _that = getType().cast(o);
		
			if (!ListEquals.listEquals(tradeIdentifier, _that.getTradeIdentifier())) return false;
			if (!Objects.equals(tradeReferenceInformation, _that.getTradeReferenceInformation())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!Objects.equals(clearingStatusValue, _that.getClearingStatusValue())) return false;
			if (!Objects.equals(updatedDateTime, _that.getUpdatedDateTime())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!ListEquals.listEquals(statusAppliesTo, _that.getStatusAppliesTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (tradeIdentifier != null ? tradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (tradeReferenceInformation != null ? tradeReferenceInformation.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (clearingStatusValue != null ? clearingStatusValue.hashCode() : 0);
			_result = 31 * _result + (updatedDateTime != null ? updatedDateTime.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (statusAppliesTo != null ? statusAppliesTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingStatusItemBuilder {" +
				"tradeIdentifier=" + this.tradeIdentifier + ", " +
				"tradeReferenceInformation=" + this.tradeReferenceInformation + ", " +
				"trade=" + this.trade + ", " +
				"tradePackage=" + this.tradePackage + ", " +
				"quote=" + this.quote + ", " +
				"clearingStatusValue=" + this.clearingStatusValue + ", " +
				"updatedDateTime=" + this.updatedDateTime + ", " +
				"reason=" + this.reason + ", " +
				"statusAppliesTo=" + this.statusAppliesTo +
			'}';
		}
	}
}
