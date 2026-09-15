package fpml.consolidated.confirmation.processes;

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
import fpml.consolidated.business.events.AdditionalEvent;
import fpml.consolidated.business.events.CompressionActivity;
import fpml.consolidated.business.events.CreditLimitInformation;
import fpml.consolidated.business.events.DeClear;
import fpml.consolidated.business.events.TerminatingEvent;
import fpml.consolidated.business.events.TradeChangeContent;
import fpml.consolidated.business.events.TradeNotionalChange;
import fpml.consolidated.business.events.TradePackage;
import fpml.consolidated.confirmation.processes.meta.ClearingConfirmedMeta;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NotificationMessage;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.msg.PortfolioReference;
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
 * Provision A message indicating that a clearing request has been acted on and as a result a trade has been cleared.
 *
 */
@RosettaDataType(value="ClearingConfirmed", builder=ClearingConfirmed.ClearingConfirmedBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ClearingConfirmed", model="fpml", builder=ClearingConfirmed.ClearingConfirmedBuilderImpl.class, version="2.1.1")
public interface ClearingConfirmed extends NotificationMessage {

	ClearingConfirmedMeta metaData = new ClearingConfirmedMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Compression information for the trade.
	 *
	 */
	CompressionActivity getCompressionActivity();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	PortfolioReference getPortfolioReference();
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
	 * Provision This may be used to describe why a trade was terminated.
	 *
	 */
	TerminatingEvent getTerminatingEvent();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeNotionalChange getTermination();
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
	Clearing getClearing();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	TradeChangeContent getChange();
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
	 * Provision 
	 *
	 */
	List<? extends CreditLimitInformation> getCreditLimitInformation();
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
	ClearingConfirmed build();
	
	ClearingConfirmed.ClearingConfirmedBuilder toBuilder();
	
	static ClearingConfirmed.ClearingConfirmedBuilder builder() {
		return new ClearingConfirmed.ClearingConfirmedBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ClearingConfirmed> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ClearingConfirmed> getType() {
		return ClearingConfirmed.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("compressionActivity"), processor, CompressionActivity.class, getCompressionActivity());
		processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioReference.class, getPortfolioReference());
		processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.class, getTradePackage());
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.class, getAdditionalEvent());
		processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.class, getTerminatingEvent());
		processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.class, getTermination());
		processRosetta(path.newSubPath("deClear"), processor, DeClear.class, getDeClear());
		processRosetta(path.newSubPath("clearing"), processor, Clearing.class, getClearing());
		processRosetta(path.newSubPath("change"), processor, TradeChangeContent.class, getChange());
		processRosetta(path.newSubPath("quote"), processor, BasicQuotation.class, getQuote());
		processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.class, getCreditLimitInformation());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ClearingConfirmedBuilder extends ClearingConfirmed, NotificationMessage.NotificationMessageBuilder {
		CompressionActivity.CompressionActivityBuilder getOrCreateCompressionActivity();
		@Override
		CompressionActivity.CompressionActivityBuilder getCompressionActivity();
		PortfolioReference.PortfolioReferenceBuilder getOrCreatePortfolioReference();
		@Override
		PortfolioReference.PortfolioReferenceBuilder getPortfolioReference();
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
		TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent();
		@Override
		TerminatingEvent.TerminatingEventBuilder getTerminatingEvent();
		TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateTermination();
		@Override
		TradeNotionalChange.TradeNotionalChangeBuilder getTermination();
		DeClear.DeClearBuilder getOrCreateDeClear();
		@Override
		DeClear.DeClearBuilder getDeClear();
		Clearing.ClearingBuilder getOrCreateClearing();
		@Override
		Clearing.ClearingBuilder getClearing();
		TradeChangeContent.TradeChangeContentBuilder getOrCreateChange();
		@Override
		TradeChangeContent.TradeChangeContentBuilder getChange();
		BasicQuotation.BasicQuotationBuilder getOrCreateQuote(int index);
		@Override
		List<? extends BasicQuotation.BasicQuotationBuilder> getQuote();
		CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation(int index);
		@Override
		List<? extends CreditLimitInformation.CreditLimitInformationBuilder> getCreditLimitInformation();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder setActualBuild(Integer actualBuild);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder setHeader(NotificationMessageHeader header);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder addValidation(Validation validation);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder addValidation(Validation validation, int idx);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder addValidation(List<? extends Validation> validation);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder setValidation(List<? extends Validation> validation);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ClearingConfirmed.ClearingConfirmedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ClearingConfirmed.ClearingConfirmedBuilder setCompressionActivity(CompressionActivity compressionActivity);
		ClearingConfirmed.ClearingConfirmedBuilder setPortfolioReference(PortfolioReference portfolioReference);
		ClearingConfirmed.ClearingConfirmedBuilder setTradePackage(TradePackage tradePackage);
		ClearingConfirmed.ClearingConfirmedBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		ClearingConfirmed.ClearingConfirmedBuilder setTrade(Trade trade);
		ClearingConfirmed.ClearingConfirmedBuilder setAdditionalEvent(AdditionalEvent additionalEvent);
		ClearingConfirmed.ClearingConfirmedBuilder setTerminatingEvent(TerminatingEvent terminatingEvent);
		ClearingConfirmed.ClearingConfirmedBuilder setTermination(TradeNotionalChange termination);
		ClearingConfirmed.ClearingConfirmedBuilder setDeClear(DeClear deClear);
		ClearingConfirmed.ClearingConfirmedBuilder setClearing(Clearing clearing);
		ClearingConfirmed.ClearingConfirmedBuilder setChange(TradeChangeContent change);
		ClearingConfirmed.ClearingConfirmedBuilder addQuote(BasicQuotation quote);
		ClearingConfirmed.ClearingConfirmedBuilder addQuote(BasicQuotation quote, int idx);
		ClearingConfirmed.ClearingConfirmedBuilder addQuote(List<? extends BasicQuotation> quote);
		ClearingConfirmed.ClearingConfirmedBuilder setQuote(List<? extends BasicQuotation> quote);
		ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation);
		ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(CreditLimitInformation creditLimitInformation, int idx);
		ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformation);
		ClearingConfirmed.ClearingConfirmedBuilder setCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformation);
		ClearingConfirmed.ClearingConfirmedBuilder addParty(Party party);
		ClearingConfirmed.ClearingConfirmedBuilder addParty(Party party, int idx);
		ClearingConfirmed.ClearingConfirmedBuilder addParty(List<? extends Party> party);
		ClearingConfirmed.ClearingConfirmedBuilder setParty(List<? extends Party> party);
		ClearingConfirmed.ClearingConfirmedBuilder addAccount(Account account);
		ClearingConfirmed.ClearingConfirmedBuilder addAccount(Account account, int idx);
		ClearingConfirmed.ClearingConfirmedBuilder addAccount(List<? extends Account> account);
		ClearingConfirmed.ClearingConfirmedBuilder setAccount(List<? extends Account> account);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("compressionActivity"), processor, CompressionActivity.CompressionActivityBuilder.class, getCompressionActivity());
			processRosetta(path.newSubPath("portfolioReference"), processor, PortfolioReference.PortfolioReferenceBuilder.class, getPortfolioReference());
			processRosetta(path.newSubPath("tradePackage"), processor, TradePackage.TradePackageBuilder.class, getTradePackage());
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("additionalEvent"), processor, AdditionalEvent.AdditionalEventBuilder.class, getAdditionalEvent());
			processRosetta(path.newSubPath("terminatingEvent"), processor, TerminatingEvent.TerminatingEventBuilder.class, getTerminatingEvent());
			processRosetta(path.newSubPath("termination"), processor, TradeNotionalChange.TradeNotionalChangeBuilder.class, getTermination());
			processRosetta(path.newSubPath("deClear"), processor, DeClear.DeClearBuilder.class, getDeClear());
			processRosetta(path.newSubPath("clearing"), processor, Clearing.ClearingBuilder.class, getClearing());
			processRosetta(path.newSubPath("change"), processor, TradeChangeContent.TradeChangeContentBuilder.class, getChange());
			processRosetta(path.newSubPath("quote"), processor, BasicQuotation.BasicQuotationBuilder.class, getQuote());
			processRosetta(path.newSubPath("creditLimitInformation"), processor, CreditLimitInformation.CreditLimitInformationBuilder.class, getCreditLimitInformation());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
		}
		

		ClearingConfirmed.ClearingConfirmedBuilder prune();
	}

	/*********************** Immutable Implementation of ClearingConfirmed  ***********************/
	class ClearingConfirmedImpl extends NotificationMessage.NotificationMessageImpl implements ClearingConfirmed {
		private final CompressionActivity compressionActivity;
		private final PortfolioReference portfolioReference;
		private final TradePackage tradePackage;
		private final OriginatingEvent originatingEvent;
		private final Trade trade;
		private final AdditionalEvent additionalEvent;
		private final TerminatingEvent terminatingEvent;
		private final TradeNotionalChange termination;
		private final DeClear deClear;
		private final Clearing clearing;
		private final TradeChangeContent change;
		private final List<? extends BasicQuotation> quote;
		private final List<? extends CreditLimitInformation> creditLimitInformation;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		
		protected ClearingConfirmedImpl(ClearingConfirmed.ClearingConfirmedBuilder builder) {
			super(builder);
			this.compressionActivity = ofNullable(builder.getCompressionActivity()).map(f->f.build()).orElse(null);
			this.portfolioReference = ofNullable(builder.getPortfolioReference()).map(f->f.build()).orElse(null);
			this.tradePackage = ofNullable(builder.getTradePackage()).map(f->f.build()).orElse(null);
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).map(f->f.build()).orElse(null);
			this.additionalEvent = ofNullable(builder.getAdditionalEvent()).map(f->f.build()).orElse(null);
			this.terminatingEvent = ofNullable(builder.getTerminatingEvent()).map(f->f.build()).orElse(null);
			this.termination = ofNullable(builder.getTermination()).map(f->f.build()).orElse(null);
			this.deClear = ofNullable(builder.getDeClear()).map(f->f.build()).orElse(null);
			this.clearing = ofNullable(builder.getClearing()).map(f->f.build()).orElse(null);
			this.change = ofNullable(builder.getChange()).map(f->f.build()).orElse(null);
			this.quote = ofNullable(builder.getQuote()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creditLimitInformation = ofNullable(builder.getCreditLimitInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("compressionActivity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compressionActivity")
		public CompressionActivity getCompressionActivity() {
			return compressionActivity;
		}
		
		@Override
		@RosettaAttribute("portfolioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioReference")
		public PortfolioReference getPortfolioReference() {
			return portfolioReference;
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
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminatingEvent")
		public TerminatingEvent getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		@RosettaAttribute("termination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termination")
		public TradeNotionalChange getTermination() {
			return termination;
		}
		
		@Override
		@RosettaAttribute("deClear")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("deClear")
		public DeClear getDeClear() {
			return deClear;
		}
		
		@Override
		@RosettaAttribute("clearing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearing")
		public Clearing getClearing() {
			return clearing;
		}
		
		@Override
		@RosettaAttribute("change")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("change")
		public TradeChangeContent getChange() {
			return change;
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
		@RosettaAttribute("creditLimitInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditLimitInformation")
		public List<? extends CreditLimitInformation> getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
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
		public ClearingConfirmed build() {
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder toBuilder() {
			ClearingConfirmed.ClearingConfirmedBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ClearingConfirmed.ClearingConfirmedBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getCompressionActivity()).ifPresent(builder::setCompressionActivity);
			ofNullable(getPortfolioReference()).ifPresent(builder::setPortfolioReference);
			ofNullable(getTradePackage()).ifPresent(builder::setTradePackage);
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getAdditionalEvent()).ifPresent(builder::setAdditionalEvent);
			ofNullable(getTerminatingEvent()).ifPresent(builder::setTerminatingEvent);
			ofNullable(getTermination()).ifPresent(builder::setTermination);
			ofNullable(getDeClear()).ifPresent(builder::setDeClear);
			ofNullable(getClearing()).ifPresent(builder::setClearing);
			ofNullable(getChange()).ifPresent(builder::setChange);
			ofNullable(getQuote()).ifPresent(builder::setQuote);
			ofNullable(getCreditLimitInformation()).ifPresent(builder::setCreditLimitInformation);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingConfirmed _that = getType().cast(o);
		
			if (!Objects.equals(compressionActivity, _that.getCompressionActivity())) return false;
			if (!Objects.equals(portfolioReference, _that.getPortfolioReference())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(clearing, _that.getClearing())) return false;
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (compressionActivity != null ? compressionActivity.hashCode() : 0);
			_result = 31 * _result + (portfolioReference != null ? portfolioReference.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (clearing != null ? clearing.hashCode() : 0);
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingConfirmed {" +
				"compressionActivity=" + this.compressionActivity + ", " +
				"portfolioReference=" + this.portfolioReference + ", " +
				"tradePackage=" + this.tradePackage + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination + ", " +
				"deClear=" + this.deClear + ", " +
				"clearing=" + this.clearing + ", " +
				"change=" + this.change + ", " +
				"quote=" + this.quote + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ClearingConfirmed  ***********************/
	class ClearingConfirmedBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl implements ClearingConfirmed.ClearingConfirmedBuilder {
	
		protected CompressionActivity.CompressionActivityBuilder compressionActivity;
		protected PortfolioReference.PortfolioReferenceBuilder portfolioReference;
		protected TradePackage.TradePackageBuilder tradePackage;
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected Trade.TradeBuilder trade;
		protected AdditionalEvent.AdditionalEventBuilder additionalEvent;
		protected TerminatingEvent.TerminatingEventBuilder terminatingEvent;
		protected TradeNotionalChange.TradeNotionalChangeBuilder termination;
		protected DeClear.DeClearBuilder deClear;
		protected Clearing.ClearingBuilder clearing;
		protected TradeChangeContent.TradeChangeContentBuilder change;
		protected List<BasicQuotation.BasicQuotationBuilder> quote = new ArrayList<>();
		protected List<CreditLimitInformation.CreditLimitInformationBuilder> creditLimitInformation = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		
		@Override
		@RosettaAttribute("compressionActivity")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("compressionActivity")
		public CompressionActivity.CompressionActivityBuilder getCompressionActivity() {
			return compressionActivity;
		}
		
		@Override
		public CompressionActivity.CompressionActivityBuilder getOrCreateCompressionActivity() {
			CompressionActivity.CompressionActivityBuilder result;
			if (compressionActivity!=null) {
				result = compressionActivity;
			}
			else {
				result = compressionActivity = CompressionActivity.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioReference")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("portfolioReference")
		public PortfolioReference.PortfolioReferenceBuilder getPortfolioReference() {
			return portfolioReference;
		}
		
		@Override
		public PortfolioReference.PortfolioReferenceBuilder getOrCreatePortfolioReference() {
			PortfolioReference.PortfolioReferenceBuilder result;
			if (portfolioReference!=null) {
				result = portfolioReference;
			}
			else {
				result = portfolioReference = PortfolioReference.builder();
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
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("terminatingEvent")
		public TerminatingEvent.TerminatingEventBuilder getTerminatingEvent() {
			return terminatingEvent;
		}
		
		@Override
		public TerminatingEvent.TerminatingEventBuilder getOrCreateTerminatingEvent() {
			TerminatingEvent.TerminatingEventBuilder result;
			if (terminatingEvent!=null) {
				result = terminatingEvent;
			}
			else {
				result = terminatingEvent = TerminatingEvent.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("termination")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("termination")
		public TradeNotionalChange.TradeNotionalChangeBuilder getTermination() {
			return termination;
		}
		
		@Override
		public TradeNotionalChange.TradeNotionalChangeBuilder getOrCreateTermination() {
			TradeNotionalChange.TradeNotionalChangeBuilder result;
			if (termination!=null) {
				result = termination;
			}
			else {
				result = termination = TradeNotionalChange.builder();
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
		@RosettaAttribute("clearing")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("clearing")
		public Clearing.ClearingBuilder getClearing() {
			return clearing;
		}
		
		@Override
		public Clearing.ClearingBuilder getOrCreateClearing() {
			Clearing.ClearingBuilder result;
			if (clearing!=null) {
				result = clearing;
			}
			else {
				result = clearing = Clearing.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("change")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("change")
		public TradeChangeContent.TradeChangeContentBuilder getChange() {
			return change;
		}
		
		@Override
		public TradeChangeContent.TradeChangeContentBuilder getOrCreateChange() {
			TradeChangeContent.TradeChangeContentBuilder result;
			if (change!=null) {
				result = change;
			}
			else {
				result = change = TradeChangeContent.builder();
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
		@RosettaAttribute("creditLimitInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("creditLimitInformation")
		public List<? extends CreditLimitInformation.CreditLimitInformationBuilder> getCreditLimitInformation() {
			return creditLimitInformation;
		}
		
		@Override
		public CreditLimitInformation.CreditLimitInformationBuilder getOrCreateCreditLimitInformation(int index) {
			if (creditLimitInformation==null) {
				this.creditLimitInformation = new ArrayList<>();
			}
			return getIndex(creditLimitInformation, index, () -> {
						CreditLimitInformation.CreditLimitInformationBuilder newCreditLimitInformation = CreditLimitInformation.builder();
						return newCreditLimitInformation;
					});
		}
		
		@Override
		@RosettaAttribute("party")
		@Accessor(AccessorType.GETTER)
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
		public ClearingConfirmed.ClearingConfirmedBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addValidation(List<? extends Validation> validations) {
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
		public ClearingConfirmed.ClearingConfirmedBuilder setValidation(List<? extends Validation> validations) {
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
		public ClearingConfirmed.ClearingConfirmedBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ClearingConfirmed.ClearingConfirmedBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ClearingConfirmed.ClearingConfirmedBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public ClearingConfirmed.ClearingConfirmedBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("compressionActivity")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("compressionActivity")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setCompressionActivity(CompressionActivity _compressionActivity) {
			this.compressionActivity = _compressionActivity == null ? null : _compressionActivity.toBuilder();
			return this;
		}
		
		@RosettaAttribute("portfolioReference")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("portfolioReference")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setPortfolioReference(PortfolioReference _portfolioReference) {
			this.portfolioReference = _portfolioReference == null ? null : _portfolioReference.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradePackage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tradePackage")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setTradePackage(TradePackage _tradePackage) {
			this.tradePackage = _tradePackage == null ? null : _tradePackage.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("trade")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setTrade(Trade _trade) {
			this.trade = _trade == null ? null : _trade.toBuilder();
			return this;
		}
		
		@RosettaAttribute("additionalEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalEvent")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setAdditionalEvent(AdditionalEvent _additionalEvent) {
			this.additionalEvent = _additionalEvent == null ? null : _additionalEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("terminatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("terminatingEvent")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setTerminatingEvent(TerminatingEvent _terminatingEvent) {
			this.terminatingEvent = _terminatingEvent == null ? null : _terminatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("termination")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("termination")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setTermination(TradeNotionalChange _termination) {
			this.termination = _termination == null ? null : _termination.toBuilder();
			return this;
		}
		
		@RosettaAttribute("deClear")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("deClear")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setDeClear(DeClear _deClear) {
			this.deClear = _deClear == null ? null : _deClear.toBuilder();
			return this;
		}
		
		@RosettaAttribute("clearing")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("clearing")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setClearing(Clearing _clearing) {
			this.clearing = _clearing == null ? null : _clearing.toBuilder();
			return this;
		}
		
		@RosettaAttribute("change")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("change")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setChange(TradeChangeContent _change) {
			this.change = _change == null ? null : _change.toBuilder();
			return this;
		}
		
		@RosettaAttribute("quote")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("quote")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addQuote(BasicQuotation _quote) {
			if (_quote != null) {
				this.quote.add(_quote.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addQuote(BasicQuotation _quote, int idx) {
			getIndex(this.quote, idx, () -> _quote.toBuilder());
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addQuote(List<? extends BasicQuotation> quotes) {
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
		public ClearingConfirmed.ClearingConfirmedBuilder setQuote(List<? extends BasicQuotation> quotes) {
			if (quotes == null) {
				this.quote = new ArrayList<>();
			} else {
				this.quote = quotes.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creditLimitInformation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("creditLimitInformation")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(CreditLimitInformation _creditLimitInformation) {
			if (_creditLimitInformation != null) {
				this.creditLimitInformation.add(_creditLimitInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(CreditLimitInformation _creditLimitInformation, int idx) {
			getIndex(this.creditLimitInformation, idx, () -> _creditLimitInformation.toBuilder());
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformations) {
			if (creditLimitInformations != null) {
				for (final CreditLimitInformation toAdd : creditLimitInformations) {
					this.creditLimitInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("creditLimitInformation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("creditLimitInformation")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setCreditLimitInformation(List<? extends CreditLimitInformation> creditLimitInformations) {
			if (creditLimitInformations == null) {
				this.creditLimitInformation = new ArrayList<>();
			} else {
				this.creditLimitInformation = creditLimitInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addParty(List<? extends Party> partys) {
			if (partys != null) {
				for (final Party toAdd : partys) {
					this.party.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("party")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder setParty(List<? extends Party> partys) {
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
		public ClearingConfirmed.ClearingConfirmedBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder addAccount(List<? extends Account> accounts) {
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
		public ClearingConfirmed.ClearingConfirmedBuilder setAccount(List<? extends Account> accounts) {
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
		public ClearingConfirmed build() {
			return new ClearingConfirmed.ClearingConfirmedImpl(this);
		}
		
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder prune() {
			super.prune();
			if (compressionActivity!=null && !compressionActivity.prune().hasData()) compressionActivity = null;
			if (portfolioReference!=null && !portfolioReference.prune().hasData()) portfolioReference = null;
			if (tradePackage!=null && !tradePackage.prune().hasData()) tradePackage = null;
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			if (trade!=null && !trade.prune().hasData()) trade = null;
			if (additionalEvent!=null && !additionalEvent.prune().hasData()) additionalEvent = null;
			if (terminatingEvent!=null && !terminatingEvent.prune().hasData()) terminatingEvent = null;
			if (termination!=null && !termination.prune().hasData()) termination = null;
			if (deClear!=null && !deClear.prune().hasData()) deClear = null;
			if (clearing!=null && !clearing.prune().hasData()) clearing = null;
			if (change!=null && !change.prune().hasData()) change = null;
			quote = quote.stream().filter(b->b!=null).<BasicQuotation.BasicQuotationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			creditLimitInformation = creditLimitInformation.stream().filter(b->b!=null).<CreditLimitInformation.CreditLimitInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getCompressionActivity()!=null && getCompressionActivity().hasData()) return true;
			if (getPortfolioReference()!=null && getPortfolioReference().hasData()) return true;
			if (getTradePackage()!=null && getTradePackage().hasData()) return true;
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTrade()!=null && getTrade().hasData()) return true;
			if (getAdditionalEvent()!=null && getAdditionalEvent().hasData()) return true;
			if (getTerminatingEvent()!=null && getTerminatingEvent().hasData()) return true;
			if (getTermination()!=null && getTermination().hasData()) return true;
			if (getDeClear()!=null && getDeClear().hasData()) return true;
			if (getClearing()!=null && getClearing().hasData()) return true;
			if (getChange()!=null && getChange().hasData()) return true;
			if (getQuote()!=null && getQuote().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreditLimitInformation()!=null && getCreditLimitInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ClearingConfirmed.ClearingConfirmedBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ClearingConfirmed.ClearingConfirmedBuilder o = (ClearingConfirmed.ClearingConfirmedBuilder) other;
			
			merger.mergeRosetta(getCompressionActivity(), o.getCompressionActivity(), this::setCompressionActivity);
			merger.mergeRosetta(getPortfolioReference(), o.getPortfolioReference(), this::setPortfolioReference);
			merger.mergeRosetta(getTradePackage(), o.getTradePackage(), this::setTradePackage);
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::setTrade);
			merger.mergeRosetta(getAdditionalEvent(), o.getAdditionalEvent(), this::setAdditionalEvent);
			merger.mergeRosetta(getTerminatingEvent(), o.getTerminatingEvent(), this::setTerminatingEvent);
			merger.mergeRosetta(getTermination(), o.getTermination(), this::setTermination);
			merger.mergeRosetta(getDeClear(), o.getDeClear(), this::setDeClear);
			merger.mergeRosetta(getClearing(), o.getClearing(), this::setClearing);
			merger.mergeRosetta(getChange(), o.getChange(), this::setChange);
			merger.mergeRosetta(getQuote(), o.getQuote(), this::getOrCreateQuote);
			merger.mergeRosetta(getCreditLimitInformation(), o.getCreditLimitInformation(), this::getOrCreateCreditLimitInformation);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ClearingConfirmed _that = getType().cast(o);
		
			if (!Objects.equals(compressionActivity, _that.getCompressionActivity())) return false;
			if (!Objects.equals(portfolioReference, _that.getPortfolioReference())) return false;
			if (!Objects.equals(tradePackage, _that.getTradePackage())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!Objects.equals(trade, _that.getTrade())) return false;
			if (!Objects.equals(additionalEvent, _that.getAdditionalEvent())) return false;
			if (!Objects.equals(terminatingEvent, _that.getTerminatingEvent())) return false;
			if (!Objects.equals(termination, _that.getTermination())) return false;
			if (!Objects.equals(deClear, _that.getDeClear())) return false;
			if (!Objects.equals(clearing, _that.getClearing())) return false;
			if (!Objects.equals(change, _that.getChange())) return false;
			if (!ListEquals.listEquals(quote, _that.getQuote())) return false;
			if (!ListEquals.listEquals(creditLimitInformation, _that.getCreditLimitInformation())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (compressionActivity != null ? compressionActivity.hashCode() : 0);
			_result = 31 * _result + (portfolioReference != null ? portfolioReference.hashCode() : 0);
			_result = 31 * _result + (tradePackage != null ? tradePackage.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (additionalEvent != null ? additionalEvent.hashCode() : 0);
			_result = 31 * _result + (terminatingEvent != null ? terminatingEvent.hashCode() : 0);
			_result = 31 * _result + (termination != null ? termination.hashCode() : 0);
			_result = 31 * _result + (deClear != null ? deClear.hashCode() : 0);
			_result = 31 * _result + (clearing != null ? clearing.hashCode() : 0);
			_result = 31 * _result + (change != null ? change.hashCode() : 0);
			_result = 31 * _result + (quote != null ? quote.hashCode() : 0);
			_result = 31 * _result + (creditLimitInformation != null ? creditLimitInformation.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ClearingConfirmedBuilder {" +
				"compressionActivity=" + this.compressionActivity + ", " +
				"portfolioReference=" + this.portfolioReference + ", " +
				"tradePackage=" + this.tradePackage + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"additionalEvent=" + this.additionalEvent + ", " +
				"terminatingEvent=" + this.terminatingEvent + ", " +
				"termination=" + this.termination + ", " +
				"deClear=" + this.deClear + ", " +
				"clearing=" + this.clearing + ", " +
				"change=" + this.change + ", " +
				"quote=" + this.quote + ", " +
				"creditLimitInformation=" + this.creditLimitInformation + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account +
			'}' + " " + super.toString();
		}
	}
}
