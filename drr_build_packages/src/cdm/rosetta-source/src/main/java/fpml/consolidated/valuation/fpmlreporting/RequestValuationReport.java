package fpml.consolidated.valuation.fpmlreporting;

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
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.CorrectableRequestMessage;
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.RequestMessageHeader;
import fpml.consolidated.riskdef.Market;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.valuation.fpmlreporting.meta.RequestValuationReportMeta;
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
 * Provision A type defining the content model for a message allowing one party a report containing valuations of one or many existing trades.
 *
 */
@RosettaDataType(value="RequestValuationReport", builder=RequestValuationReport.RequestValuationReportBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestValuationReport", model="fpml", builder=RequestValuationReport.RequestValuationReportBuilderImpl.class, version="2.1.1")
public interface RequestValuationReport extends CorrectableRequestMessage {

	RequestValuationReportMeta metaData = new RequestValuationReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specific characteristics to be included in the report.
	 *
	 */
	ReportContents getReportContents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date for which this report is requested.
	 *
	 */
	IdentifiedDate getAsOfDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
	 *
	 */
	List<? extends Party> getParty();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Optional account information used to precisely define the origination and destination of financial instruments.
	 *
	 */
	List<? extends Account> getAccount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	Market getMarket();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An instance of a unique portfolio valuation.
	 *
	 */
	List<? extends PortfolioValuationItem> getPortfolioValuationItem();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An instance of a unique trade valuation.
	 *
	 */
	List<? extends TradeValuationItem> getTradeValuationItem();

	/*********************** Build Methods  ***********************/
	RequestValuationReport build();
	
	RequestValuationReport.RequestValuationReportBuilder toBuilder();
	
	static RequestValuationReport.RequestValuationReportBuilder builder() {
		return new RequestValuationReport.RequestValuationReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestValuationReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestValuationReport> getType() {
		return RequestValuationReport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
		processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.class, getParentCorrelationId());
		processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.class, getCorrelationId());
		processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("reportContents"), processor, ReportContents.class, getReportContents());
		processRosetta(path.newSubPath("asOfDate"), processor, IdentifiedDate.class, getAsOfDate());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("market"), processor, Market.class, getMarket());
		processRosetta(path.newSubPath("portfolioValuationItem"), processor, PortfolioValuationItem.class, getPortfolioValuationItem());
		processRosetta(path.newSubPath("tradeValuationItem"), processor, TradeValuationItem.class, getTradeValuationItem());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestValuationReportBuilder extends RequestValuationReport, CorrectableRequestMessage.CorrectableRequestMessageBuilder {
		ReportContents.ReportContentsBuilder getOrCreateReportContents();
		@Override
		ReportContents.ReportContentsBuilder getReportContents();
		IdentifiedDate.IdentifiedDateBuilder getOrCreateAsOfDate();
		@Override
		IdentifiedDate.IdentifiedDateBuilder getAsOfDate();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		Market.MarketBuilder getOrCreateMarket();
		@Override
		Market.MarketBuilder getMarket();
		PortfolioValuationItem.PortfolioValuationItemBuilder getOrCreatePortfolioValuationItem(int index);
		@Override
		List<? extends PortfolioValuationItem.PortfolioValuationItemBuilder> getPortfolioValuationItem();
		TradeValuationItem.TradeValuationItemBuilder getOrCreateTradeValuationItem(int index);
		@Override
		List<? extends TradeValuationItem.TradeValuationItemBuilder> getTradeValuationItem();
		@Override
		RequestValuationReport.RequestValuationReportBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestValuationReport.RequestValuationReportBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestValuationReport.RequestValuationReportBuilder setActualBuild(Integer actualBuild);
		@Override
		RequestValuationReport.RequestValuationReportBuilder setHeader(RequestMessageHeader header);
		@Override
		RequestValuationReport.RequestValuationReportBuilder addValidation(Validation validation);
		@Override
		RequestValuationReport.RequestValuationReportBuilder addValidation(Validation validation, int idx);
		@Override
		RequestValuationReport.RequestValuationReportBuilder addValidation(List<? extends Validation> validation);
		@Override
		RequestValuationReport.RequestValuationReportBuilder setValidation(List<? extends Validation> validation);
		@Override
		RequestValuationReport.RequestValuationReportBuilder setIsCorrection(Boolean isCorrection);
		@Override
		RequestValuationReport.RequestValuationReportBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		RequestValuationReport.RequestValuationReportBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		RequestValuationReport.RequestValuationReportBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		RequestValuationReport.RequestValuationReportBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestValuationReport.RequestValuationReportBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		RequestValuationReport.RequestValuationReportBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		RequestValuationReport.RequestValuationReportBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		RequestValuationReport.RequestValuationReportBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		RequestValuationReport.RequestValuationReportBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		RequestValuationReport.RequestValuationReportBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		RequestValuationReport.RequestValuationReportBuilder setReportContents(ReportContents reportContents);
		RequestValuationReport.RequestValuationReportBuilder setAsOfDate(IdentifiedDate asOfDate);
		RequestValuationReport.RequestValuationReportBuilder addParty(Party party);
		RequestValuationReport.RequestValuationReportBuilder addParty(Party party, int idx);
		RequestValuationReport.RequestValuationReportBuilder addParty(List<? extends Party> party);
		RequestValuationReport.RequestValuationReportBuilder setParty(List<? extends Party> party);
		RequestValuationReport.RequestValuationReportBuilder addAccount(Account account);
		RequestValuationReport.RequestValuationReportBuilder addAccount(Account account, int idx);
		RequestValuationReport.RequestValuationReportBuilder addAccount(List<? extends Account> account);
		RequestValuationReport.RequestValuationReportBuilder setAccount(List<? extends Account> account);
		RequestValuationReport.RequestValuationReportBuilder setMarket(Market market);
		RequestValuationReport.RequestValuationReportBuilder addPortfolioValuationItem(PortfolioValuationItem portfolioValuationItem);
		RequestValuationReport.RequestValuationReportBuilder addPortfolioValuationItem(PortfolioValuationItem portfolioValuationItem, int idx);
		RequestValuationReport.RequestValuationReportBuilder addPortfolioValuationItem(List<? extends PortfolioValuationItem> portfolioValuationItem);
		RequestValuationReport.RequestValuationReportBuilder setPortfolioValuationItem(List<? extends PortfolioValuationItem> portfolioValuationItem);
		RequestValuationReport.RequestValuationReportBuilder addTradeValuationItem(TradeValuationItem tradeValuationItem);
		RequestValuationReport.RequestValuationReportBuilder addTradeValuationItem(TradeValuationItem tradeValuationItem, int idx);
		RequestValuationReport.RequestValuationReportBuilder addTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItem);
		RequestValuationReport.RequestValuationReportBuilder setTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItem);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processor.processBasic(path.newSubPath("isCorrection"), Boolean.class, getIsCorrection(), this);
			processRosetta(path.newSubPath("parentCorrelationId"), processor, CorrelationId.CorrelationIdBuilder.class, getParentCorrelationId());
			processRosetta(path.newSubPath("correlationId"), processor, CorrelationId.CorrelationIdBuilder.class, getCorrelationId());
			processor.processBasic(path.newSubPath("sequenceNumber"), Integer.class, getSequenceNumber(), this);
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("reportContents"), processor, ReportContents.ReportContentsBuilder.class, getReportContents());
			processRosetta(path.newSubPath("asOfDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAsOfDate());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("market"), processor, Market.MarketBuilder.class, getMarket());
			processRosetta(path.newSubPath("portfolioValuationItem"), processor, PortfolioValuationItem.PortfolioValuationItemBuilder.class, getPortfolioValuationItem());
			processRosetta(path.newSubPath("tradeValuationItem"), processor, TradeValuationItem.TradeValuationItemBuilder.class, getTradeValuationItem());
		}
		

		RequestValuationReport.RequestValuationReportBuilder prune();
	}

	/*********************** Immutable Implementation of RequestValuationReport  ***********************/
	class RequestValuationReportImpl extends CorrectableRequestMessage.CorrectableRequestMessageImpl implements RequestValuationReport {
		private final ReportContents reportContents;
		private final IdentifiedDate asOfDate;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		private final Market market;
		private final List<? extends PortfolioValuationItem> portfolioValuationItem;
		private final List<? extends TradeValuationItem> tradeValuationItem;
		
		protected RequestValuationReportImpl(RequestValuationReport.RequestValuationReportBuilder builder) {
			super(builder);
			this.reportContents = ofNullable(builder.getReportContents()).map(f->f.build()).orElse(null);
			this.asOfDate = ofNullable(builder.getAsOfDate()).map(f->f.build()).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.market = ofNullable(builder.getMarket()).map(f->f.build()).orElse(null);
			this.portfolioValuationItem = ofNullable(builder.getPortfolioValuationItem()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeValuationItem = ofNullable(builder.getTradeValuationItem()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportContents")
		public ReportContents getReportContents() {
			return reportContents;
		}
		
		@Override
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfDate")
		public IdentifiedDate getAsOfDate() {
			return asOfDate;
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
		@RosettaAttribute("market")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("market")
		public Market getMarket() {
			return market;
		}
		
		@Override
		@RosettaAttribute("portfolioValuationItem")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("portfolioValuationItem")
		public List<? extends PortfolioValuationItem> getPortfolioValuationItem() {
			return portfolioValuationItem;
		}
		
		@Override
		@RosettaAttribute("tradeValuationItem")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeValuationItem")
		public List<? extends TradeValuationItem> getTradeValuationItem() {
			return tradeValuationItem;
		}
		
		@Override
		public RequestValuationReport build() {
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder toBuilder() {
			RequestValuationReport.RequestValuationReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestValuationReport.RequestValuationReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportContents()).ifPresent(builder::setReportContents);
			ofNullable(getAsOfDate()).ifPresent(builder::setAsOfDate);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
			ofNullable(getMarket()).ifPresent(builder::setMarket);
			ofNullable(getPortfolioValuationItem()).ifPresent(builder::setPortfolioValuationItem);
			ofNullable(getTradeValuationItem()).ifPresent(builder::setTradeValuationItem);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(reportContents, _that.getReportContents())) return false;
			if (!Objects.equals(asOfDate, _that.getAsOfDate())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!Objects.equals(market, _that.getMarket())) return false;
			if (!ListEquals.listEquals(portfolioValuationItem, _that.getPortfolioValuationItem())) return false;
			if (!ListEquals.listEquals(tradeValuationItem, _that.getTradeValuationItem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportContents != null ? reportContents.hashCode() : 0);
			_result = 31 * _result + (asOfDate != null ? asOfDate.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (market != null ? market.hashCode() : 0);
			_result = 31 * _result + (portfolioValuationItem != null ? portfolioValuationItem.hashCode() : 0);
			_result = 31 * _result + (tradeValuationItem != null ? tradeValuationItem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestValuationReport {" +
				"reportContents=" + this.reportContents + ", " +
				"asOfDate=" + this.asOfDate + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"market=" + this.market + ", " +
				"portfolioValuationItem=" + this.portfolioValuationItem + ", " +
				"tradeValuationItem=" + this.tradeValuationItem +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestValuationReport  ***********************/
	class RequestValuationReportBuilderImpl extends CorrectableRequestMessage.CorrectableRequestMessageBuilderImpl implements RequestValuationReport.RequestValuationReportBuilder {
	
		protected ReportContents.ReportContentsBuilder reportContents;
		protected IdentifiedDate.IdentifiedDateBuilder asOfDate;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		protected Market.MarketBuilder market;
		protected List<PortfolioValuationItem.PortfolioValuationItemBuilder> portfolioValuationItem = new ArrayList<>();
		protected List<TradeValuationItem.TradeValuationItemBuilder> tradeValuationItem = new ArrayList<>();
		
		@Override
		@RosettaAttribute("reportContents")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportContents")
		public ReportContents.ReportContentsBuilder getReportContents() {
			return reportContents;
		}
		
		@Override
		public ReportContents.ReportContentsBuilder getOrCreateReportContents() {
			ReportContents.ReportContentsBuilder result;
			if (reportContents!=null) {
				result = reportContents;
			}
			else {
				result = reportContents = ReportContents.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfDate")
		public IdentifiedDate.IdentifiedDateBuilder getAsOfDate() {
			return asOfDate;
		}
		
		@Override
		public IdentifiedDate.IdentifiedDateBuilder getOrCreateAsOfDate() {
			IdentifiedDate.IdentifiedDateBuilder result;
			if (asOfDate!=null) {
				result = asOfDate;
			}
			else {
				result = asOfDate = IdentifiedDate.builder();
			}
			
			return result;
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
		
		@Override
		@RosettaAttribute("market")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("market")
		public Market.MarketBuilder getMarket() {
			return market;
		}
		
		@Override
		public Market.MarketBuilder getOrCreateMarket() {
			Market.MarketBuilder result;
			if (market!=null) {
				result = market;
			}
			else {
				result = market = Market.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("portfolioValuationItem")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("portfolioValuationItem")
		public List<? extends PortfolioValuationItem.PortfolioValuationItemBuilder> getPortfolioValuationItem() {
			return portfolioValuationItem;
		}
		
		@Override
		public PortfolioValuationItem.PortfolioValuationItemBuilder getOrCreatePortfolioValuationItem(int index) {
			if (portfolioValuationItem==null) {
				this.portfolioValuationItem = new ArrayList<>();
			}
			return getIndex(portfolioValuationItem, index, () -> {
						PortfolioValuationItem.PortfolioValuationItemBuilder newPortfolioValuationItem = PortfolioValuationItem.builder();
						return newPortfolioValuationItem;
					});
		}
		
		@Override
		@RosettaAttribute("tradeValuationItem")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeValuationItem")
		public List<? extends TradeValuationItem.TradeValuationItemBuilder> getTradeValuationItem() {
			return tradeValuationItem;
		}
		
		@Override
		public TradeValuationItem.TradeValuationItemBuilder getOrCreateTradeValuationItem(int index) {
			if (tradeValuationItem==null) {
				this.tradeValuationItem = new ArrayList<>();
			}
			return getIndex(tradeValuationItem, index, () -> {
						TradeValuationItem.TradeValuationItemBuilder newTradeValuationItem = TradeValuationItem.builder();
						return newTradeValuationItem;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addValidation(List<? extends Validation> validations) {
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
		public RequestValuationReport.RequestValuationReportBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("isCorrection")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("isCorrection")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setIsCorrection(Boolean _isCorrection) {
			this.isCorrection = _isCorrection == null ? null : _isCorrection;
			return this;
		}
		
		@RosettaAttribute("parentCorrelationId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("parentCorrelationId")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestValuationReport.RequestValuationReportBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public RequestValuationReport.RequestValuationReportBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public RequestValuationReport.RequestValuationReportBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportContents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportContents")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setReportContents(ReportContents _reportContents) {
			this.reportContents = _reportContents == null ? null : _reportContents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asOfDate")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setAsOfDate(IdentifiedDate _asOfDate) {
			this.asOfDate = _asOfDate == null ? null : _asOfDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addParty(List<? extends Party> partys) {
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
		public RequestValuationReport.RequestValuationReportBuilder setParty(List<? extends Party> partys) {
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
		public RequestValuationReport.RequestValuationReportBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addAccount(List<? extends Account> accounts) {
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
		public RequestValuationReport.RequestValuationReportBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null) {
				this.account = new ArrayList<>();
			} else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("market")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("market")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setMarket(Market _market) {
			this.market = _market == null ? null : _market.toBuilder();
			return this;
		}
		
		@RosettaAttribute("portfolioValuationItem")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("portfolioValuationItem")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addPortfolioValuationItem(PortfolioValuationItem _portfolioValuationItem) {
			if (_portfolioValuationItem != null) {
				this.portfolioValuationItem.add(_portfolioValuationItem.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addPortfolioValuationItem(PortfolioValuationItem _portfolioValuationItem, int idx) {
			getIndex(this.portfolioValuationItem, idx, () -> _portfolioValuationItem.toBuilder());
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addPortfolioValuationItem(List<? extends PortfolioValuationItem> portfolioValuationItems) {
			if (portfolioValuationItems != null) {
				for (final PortfolioValuationItem toAdd : portfolioValuationItems) {
					this.portfolioValuationItem.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("portfolioValuationItem")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("portfolioValuationItem")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setPortfolioValuationItem(List<? extends PortfolioValuationItem> portfolioValuationItems) {
			if (portfolioValuationItems == null) {
				this.portfolioValuationItem = new ArrayList<>();
			} else {
				this.portfolioValuationItem = portfolioValuationItems.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("tradeValuationItem")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeValuationItem")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addTradeValuationItem(TradeValuationItem _tradeValuationItem) {
			if (_tradeValuationItem != null) {
				this.tradeValuationItem.add(_tradeValuationItem.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addTradeValuationItem(TradeValuationItem _tradeValuationItem, int idx) {
			getIndex(this.tradeValuationItem, idx, () -> _tradeValuationItem.toBuilder());
			return this;
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder addTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItems) {
			if (tradeValuationItems != null) {
				for (final TradeValuationItem toAdd : tradeValuationItems) {
					this.tradeValuationItem.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeValuationItem")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeValuationItem")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder setTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItems) {
			if (tradeValuationItems == null) {
				this.tradeValuationItem = new ArrayList<>();
			} else {
				this.tradeValuationItem = tradeValuationItems.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RequestValuationReport build() {
			return new RequestValuationReport.RequestValuationReportImpl(this);
		}
		
		@Override
		public RequestValuationReport.RequestValuationReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder prune() {
			super.prune();
			if (reportContents!=null && !reportContents.prune().hasData()) reportContents = null;
			if (asOfDate!=null && !asOfDate.prune().hasData()) asOfDate = null;
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (market!=null && !market.prune().hasData()) market = null;
			portfolioValuationItem = portfolioValuationItem.stream().filter(b->b!=null).<PortfolioValuationItem.PortfolioValuationItemBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			tradeValuationItem = tradeValuationItem.stream().filter(b->b!=null).<TradeValuationItem.TradeValuationItemBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReportContents()!=null && getReportContents().hasData()) return true;
			if (getAsOfDate()!=null && getAsOfDate().hasData()) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMarket()!=null && getMarket().hasData()) return true;
			if (getPortfolioValuationItem()!=null && getPortfolioValuationItem().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeValuationItem()!=null && getTradeValuationItem().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestValuationReport.RequestValuationReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestValuationReport.RequestValuationReportBuilder o = (RequestValuationReport.RequestValuationReportBuilder) other;
			
			merger.mergeRosetta(getReportContents(), o.getReportContents(), this::setReportContents);
			merger.mergeRosetta(getAsOfDate(), o.getAsOfDate(), this::setAsOfDate);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			merger.mergeRosetta(getMarket(), o.getMarket(), this::setMarket);
			merger.mergeRosetta(getPortfolioValuationItem(), o.getPortfolioValuationItem(), this::getOrCreatePortfolioValuationItem);
			merger.mergeRosetta(getTradeValuationItem(), o.getTradeValuationItem(), this::getOrCreateTradeValuationItem);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(reportContents, _that.getReportContents())) return false;
			if (!Objects.equals(asOfDate, _that.getAsOfDate())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!Objects.equals(market, _that.getMarket())) return false;
			if (!ListEquals.listEquals(portfolioValuationItem, _that.getPortfolioValuationItem())) return false;
			if (!ListEquals.listEquals(tradeValuationItem, _that.getTradeValuationItem())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportContents != null ? reportContents.hashCode() : 0);
			_result = 31 * _result + (asOfDate != null ? asOfDate.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (market != null ? market.hashCode() : 0);
			_result = 31 * _result + (portfolioValuationItem != null ? portfolioValuationItem.hashCode() : 0);
			_result = 31 * _result + (tradeValuationItem != null ? tradeValuationItem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestValuationReportBuilder {" +
				"reportContents=" + this.reportContents + ", " +
				"asOfDate=" + this.asOfDate + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"market=" + this.market + ", " +
				"portfolioValuationItem=" + this.portfolioValuationItem + ", " +
				"tradeValuationItem=" + this.tradeValuationItem +
			'}' + " " + super.toString();
		}
	}
}
