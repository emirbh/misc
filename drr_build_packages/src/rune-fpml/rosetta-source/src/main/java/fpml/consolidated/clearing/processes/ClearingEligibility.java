package fpml.consolidated.clearing.processes;

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
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.DeClear;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.clearing.processes.meta.ClearingEligibilityMeta;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.ResponseMessage;
import fpml.consolidated.msg.ResponseMessageHeader;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
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
 * Provision 
 *
 */
@RosettaDataType(value="ClearingEligibility", builder=ClearingEligibility.ClearingEligibilityBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClearingEligibility", model="fpml", builder=ClearingEligibility.ClearingEligibilityBuilderImpl.class, version="2.1.1")
public interface ClearingEligibility extends ResponseMessage {

	ClearingEligibilityMeta metaData = new ClearingEligibilityMeta();

	/*********************** Getter Methods  ***********************/
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
	 * Provision 
	 *
	 */
	OriginatingEvent getOriginatingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
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
	AdditionalEvent getAdditionalEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A structure describing a declear event. The deClear event allows a firm to request that a trade be removed from clearing, or a clearing service to request consent for this, or to report that it has been done.
	 *
	 */
	DeClear getDeClear();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	PartyTradeIdentifier getPartyTradeIdentifier();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	Boolean getEligibleForClearing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends ClearingRequirements> getClearingRequirements();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
	 *
	 */
	List<? extends Party> getParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optional account information used to precisely define the origination and destination of financial instruments.
	 *
	 */
	List<? extends Account> getAccount();

	/*********************** Build Methods  ***********************/
	ClearingEligibility build();
	
	ClearingEligibility.ClearingEligibilityBuilder toBuilder();
	
	static ClearingEligibility.ClearingEligibilityBuilder builder() {
		return new ClearingEligibility.ClearingEligibilityBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingEligibility> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingEligibility> getType() {
		return ClearingEligibility.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.class, getTradePackage());
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processor.processBasic(path.newSubPath("eligibleForClearing"), Boolean.class, getEligibleForClearing(), this);
		processRosetta(path.newSubPath("clearingRequirements"), processor, ClearingRequirements.class, getClearingRequirements());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingEligibilityBuilder extends ClearingEligibility, ResponseMessage.ResponseMessageBuilder {
		TradePackage.TradePackageBuilder getOrCreateTradePackage();
		@Override
		TradePackage.TradePackageBuilder getTradePackage();
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		@Override
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		Trade.TradeBuilder getOrCreateTrade();
		@Override
		Trade.TradeBuilder getTrade();
		AdditionalEvent.AdditionalEventBuilder getOrCreateAdditionalEvent();
		@Override
		AdditionalEvent.AdditionalEventBuilder getAdditionalEvent();
		DeClear.DeClearBuilder getOrCreateDeClear();
		@Override
		DeClear.DeClearBuilder getDeClear();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier();
		@Override
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getPartyTradeIdentifier();
		ClearingRequirements.ClearingRequirementsBuilder getOrCreateClearingRequirements(int index);
		@Override
		List<? extends ClearingRequirements.ClearingRequirementsBuilder> getClearingRequirements();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		ClearingEligibility.ClearingEligibilityBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder setActualBuild(Integer actualBuild);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder setHeader(ResponseMessageHeader header);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder addValidation(Validation validation);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder addValidation(Validation validation, int idx);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder addValidation(List<? extends Validation> validation);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder setValidation(List<? extends Validation> validation);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ClearingEligibility.ClearingEligibilityBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ClearingEligibility.ClearingEligibilityBuilder setTradePackage(TradePackage tradePackage);
		ClearingEligibility.ClearingEligibilityBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		ClearingEligibility.ClearingEligibilityBuilder setTrade(Trade trade);
		ClearingEligibility.ClearingEligibilityBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		ClearingEligibility.ClearingEligibilityBuilder setDeClear(DeClear deClear);
		ClearingEligibility.ClearingEligibilityBuilder setPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		ClearingEligibility.ClearingEligibilityBuilder setEligibleForClearing(Boolean eligibleForClearing);
		ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(ClearingRequirements clearingRequirements);
		ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(ClearingRequirements clearingRequirements, int idx);
		ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(List<? extends ClearingRequirements> clearingRequirements);
		ClearingEligibility.ClearingEligibilityBuilder setClearingRequirements(List<? extends ClearingRequirements> clearingRequirements);
		ClearingEligibility.ClearingEligibilityBuilder addParty(Party party);
		ClearingEligibility.ClearingEligibilityBuilder addParty(Party party, int idx);
		ClearingEligibility.ClearingEligibilityBuilder addParty(List<? extends Party> party);
		ClearingEligibility.ClearingEligibilityBuilder setParty(List<? extends Party> party);
		ClearingEligibility.ClearingEligibilityBuilder addAccount(Account account);
		ClearingEligibility.ClearingEligibilityBuilder addAccount(Account account, int idx);
		ClearingEligibility.ClearingEligibilityBuilder addAccount(List<? extends Account> account);
		ClearingEligibility.ClearingEligibilityBuilder setAccount(List<? extends Account> account);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ResponseMessageHeader.ResponseMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.TradePackageBuilder.class, getTradePackage());
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processor.processBasic(path.newSubPath("eligibleForClearing"), Boolean.class, getEligibleForClearing(), this);
			processRosetta(path.newSubPath("clearingRequirements"), processor, ClearingRequirements.ClearingRequirementsBuilder.class, getClearingRequirements());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		ClearingEligibility.ClearingEligibilityBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingEligibility  ***********************/
	class ClearingEligibilityImpl extends ResponseMessage.ResponseMessageImpl implements ClearingEligibility {
		private final TradePackage tradePackage;
		private final OriginatingEvent originatingEvent;
		private final Trade trade;
		private final AdditionalEvent additionalEvent;
		private final DeClear deClear;
		private final PartyTradeIdentifier partyTradeIdentifier;
		private final Boolean eligibleForClearing;
		private final List<? extends ClearingRequirements> clearingRequirements;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected ClearingEligibilityImpl(ClearingEligibility.ClearingEligibilityBuilder builder) {
			super(builder);
			this.tradePackage = ofNullable(builder.getTradePackage()).map(f->f.build()).orElse(null);
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).map(f->f.build()).orElse(null);
			this.eligibleForClearing = builder.getEligibleForClearing();
			this.clearingRequirements = ofNullable(builder.getClearingRequirements()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tradePackage")
		public TradePackage getTradePackage() {
			return tradePackage;
		}
		
		@Override
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		@RosettaAttribute("trade")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("trade")
		public Trade getTrade() {
			return trade;
		}
		
		@Override
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalEvent")
		public AdditionalEvent getAdditionalEvent() {
			return additionalEvent;
		}
		
		@Override
		@RosettaAttribute("deClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deClear")
		public DeClear getDeClear() {
			return deClear;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyTradeIdentifier")
		public PartyTradeIdentifier getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		@RosettaAttribute("eligibleForClearing")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eligibleForClearing")
		public Boolean getEligibleForClearing() {
			return eligibleForClearing;
		}
		
		@Override
		@RosettaAttribute("clearingRequirements")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingRequirements")
		public List<? extends ClearingRequirements> getClearingRequirements() {
			return clearingRequirements;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party> getParty() {
			return party;
		}
		
		@Override
		@RosettaAttribute("account")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("account")
		public List<? extends Account> getAccount() {
			return account;
		}
		
		@Override
		public ClearingEligibility build() {
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder toBuilder() {
			ClearingEligibility.ClearingEligibilityBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingEligibility.ClearingEligibilityBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getTradePackage()).ifPresent(builder::setTradePackage);
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getEligibleForClearing()).ifPresent(builder::setEligibleForClearing);
			ofNullable(getClearingRequirements()).ifPresent(builder::setClearingRequirements);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingEligibility _that = getType().cast(o);
		
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!Objects.equals(eligibleForClearing, _that.getEligibleForClearing())) return false;
			if (!ListEquals.listEquals(clearingRequirements, _that.getClearingRequirements())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (eligibleForClearing != null ? eligibleForClearing.hashCode() : 0);
			_result = 31 * _result + (clearingRequirements != null ? clearingRequirements.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingEligibility {" +
				"tradePackage=" + this.tradePackage + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"deClear=" + this.deClear + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"eligibleForClearing=" + this.eligibleForClearing + ", " +
				"clearingRequirements=" + this.clearingRequirements + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClearingEligibility  ***********************/
	class ClearingEligibilityBuilderImpl extends ResponseMessage.ResponseMessageBuilderImpl implements ClearingEligibility.ClearingEligibilityBuilder {
	
		protected TradePackage.TradePackageBuilder tradePackage;
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected Trade.TradeBuilder trade;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
		protected DeClear.DeClearBuilder deClear;
		protected PartyTradeIdentifier.PartyTradeIdentifierBuilder partyTradeIdentifier;
		protected Boolean eligibleForClearing;
		protected List<ClearingRequirements.ClearingRequirementsBuilder> clearingRequirements = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
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
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originatingEvent")
		public OriginatingEvent.OriginatingEventBuilder getOriginatingEvent() {
			return originatingEvent;
		}
		
		@Override
		public OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent() {
			OriginatingEvent.OriginatingEventBuilder result;
			if (originatingEvent!=null) {
				result = originatingEvent;
			}
			else {
				result = originatingEvent = OriginatingEvent.builder();
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
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalEvent")
		public AdditionalEvent.AdditionalEventBuilder getAdditionalEvent() {
			return additionalEvent;
		}
		
		@Override
		public AdditionalEvent.AdditionalEventBuilder getOrCreateAdditionalEvent() {
			AdditionalEvent.AdditionalEventBuilder result;
			if (additionalEvent!=null) {
				result = additionalEvent;
			}
			else {
				result = additionalEvent = AdditionalEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("deClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deClear")
		public DeClear.DeClearBuilder getDeClear() {
			return deClear;
		}
		
		@Override
		public DeClear.DeClearBuilder getOrCreateDeClear() {
			DeClear.DeClearBuilder result;
			if (deClear!=null) {
				result = deClear;
			}
			else {
				result = deClear = DeClear.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyTradeIdentifier")
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier() {
			PartyTradeIdentifier.PartyTradeIdentifierBuilder result;
			if (partyTradeIdentifier!=null) {
				result = partyTradeIdentifier;
			}
			else {
				result = partyTradeIdentifier = PartyTradeIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eligibleForClearing")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("eligibleForClearing")
		public Boolean getEligibleForClearing() {
			return eligibleForClearing;
		}
		
		@Override
		@RosettaAttribute("clearingRequirements")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("clearingRequirements")
		public List<? extends ClearingRequirements.ClearingRequirementsBuilder> getClearingRequirements() {
			return clearingRequirements;
		}
		
		@Override
		public ClearingRequirements.ClearingRequirementsBuilder getOrCreateClearingRequirements(int index) {
			if (clearingRequirements==null) {
				this.clearingRequirements = new ArrayList<>();
			}
			return getIndex(clearingRequirements, index, () -> {
						ClearingRequirements.ClearingRequirementsBuilder newClearingRequirements = ClearingRequirements.builder();
						return newClearingRequirements;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		public List<? extends Party.PartyBuilder> getParty() {
			return party;
		}
		
		@Override
		public Party.PartyBuilder getOrCreateParty(int index) {
			if (party==null) {
				this.party = new ArrayList<>();
			}
			return getIndex(party, index, () -> {
						Party.PartyBuilder newParty = Party.builder();
						return newParty;
					});
		}
		
		@Override
		@RosettaAttribute("account")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("account")
		public List<? extends Account.AccountBuilder> getAccount() {
			return account;
		}
		
		@Override
		public Account.AccountBuilder getOrCreateAccount(int index) {
			if (account==null) {
				this.account = new ArrayList<>();
			}
			return getIndex(account, index, () -> {
						Account.AccountBuilder newAccount = Account.builder();
						return newAccount;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setHeader(ResponseMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (final Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds != null) {
				for (final CorrelationId toAdd : correlationIds) {
					this.correlationId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
			if (correlationIds == null) {
				this.correlationId = new ArrayList<>();
			} else {
				this.correlationId = correlationIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("sequenceNumber")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sequenceNumber")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs != null) {
				for (final OnBehalfOf toAdd : onBehalfOfs) {
					this.onBehalfOf.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePackage")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setTradePackage(TradePackage _tradePackage) {
			this.tradePackage = _tradePackage == null ? null : _tradePackage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalEvent")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setAdditionalEvent(AdditionalEvent _additionalEvent) {
			this.additionalEvent = _additionalEvent == null ? null : _additionalEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deClear")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deClear")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setDeClear(DeClear _deClear) {
			this.deClear = _deClear == null ? null : _deClear.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier) {
			this.partyTradeIdentifier = _partyTradeIdentifier == null ? null : _partyTradeIdentifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eligibleForClearing")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("eligibleForClearing")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setEligibleForClearing(Boolean _eligibleForClearing) {
			this.eligibleForClearing = _eligibleForClearing == null ? null : _eligibleForClearing;
			return this;
		}
		
		@RosettaAttribute("clearingRequirements")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("clearingRequirements")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(ClearingRequirements _clearingRequirements) {
			if (_clearingRequirements != null) {
				this.clearingRequirements.add(_clearingRequirements.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(ClearingRequirements _clearingRequirements, int idx) {
			getIndex(this.clearingRequirements, idx, () -> _clearingRequirements.toBuilder());
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addClearingRequirements(List<? extends ClearingRequirements> clearingRequirementss) {
			if (clearingRequirementss != null) {
				for (final ClearingRequirements toAdd : clearingRequirementss) {
					this.clearingRequirements.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("clearingRequirements")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("clearingRequirements")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setClearingRequirements(List<? extends ClearingRequirements> clearingRequirementss) {
			if (clearingRequirementss == null) {
				this.clearingRequirements = new ArrayList<>();
			} else {
				this.clearingRequirements = clearingRequirementss.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Required
		@Multi
		@RuneAttribute("party")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setParty(List<? extends Party> partys) {
			if (partys == null) {
				this.party = new ArrayList<>();
			} else {
				this.party = partys.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("account")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("account")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder addAccount(List<? extends Account> accounts) {
			if (accounts != null) {
				for (final Account toAdd : accounts) {
					this.account.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("account")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("account")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null) {
				this.account = new ArrayList<>();
			} else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ClearingEligibility build() {
			return new ClearingEligibility.ClearingEligibilityImpl(this);
		}
		
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder prune() {
			super.prune();
			if (tradePackage!=null && !tradePackage.prune().hasData()) tradePackage = null;
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			if (partyTradeIdentifier!=null && !partyTradeIdentifier.prune().hasData()) partyTradeIdentifier = null;
			clearingRequirements = clearingRequirements.stream().filter(b->b!=null).<ClearingRequirements.ClearingRequirementsBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getTradePackage()!=null && getTradePackage().hasData()) return true;
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().hasData()) return true;
			if (getEligibleForClearing()!=null) return true;
			if (getClearingRequirements()!=null && getClearingRequirements().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingEligibility.ClearingEligibilityBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ClearingEligibility.ClearingEligibilityBuilder o = (ClearingEligibility.ClearingEligibilityBuilder) other;
			
			merger.mergeRosetta(getTradePackage(), o.getTradePackage(), this::setTradePackage);
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			merger.mergeRosetta(getDeClear(), o.getDeClear(), this::setDeClear);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::setPartyTradeIdentifier);
			merger.mergeRosetta(getClearingRequirements(), o.getClearingRequirements(), this::getOrCreateClearingRequirements);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			merger.mergeBasic(getEligibleForClearing(), o.getEligibleForClearing(), this::setEligibleForClearing);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingEligibility _that = getType().cast(o);
		
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!Objects.equals(eligibleForClearing, _that.getEligibleForClearing())) return false;
			if (!ListEquals.listEquals(clearingRequirements, _that.getClearingRequirements())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (eligibleForClearing != null ? eligibleForClearing.hashCode() : 0);
			_result = 31 * _result + (clearingRequirements != null ? clearingRequirements.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingEligibilityBuilder {" +
				"tradePackage=" + this.tradePackage + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"deClear=" + this.deClear + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"eligibleForClearing=" + this.eligibleForClearing + ", " +
				"clearingRequirements=" + this.clearingRequirements + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}
