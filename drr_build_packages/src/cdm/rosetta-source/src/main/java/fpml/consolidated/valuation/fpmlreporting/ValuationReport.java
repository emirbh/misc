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
import fpml.consolidated.msg.CorrelationId;
import fpml.consolidated.msg.NotificationMessage;
import fpml.consolidated.msg.NotificationMessageHeader;
import fpml.consolidated.msg.ReportIdentification;
import fpml.consolidated.riskdef.Market;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.IdentifiedDate;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.Party;
import fpml.consolidated.valuation.fpmlreporting.meta.ValuationReportMeta;
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
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the content model for a message normally generated in response to a RequestValuationReport request.
 *
 */
@RosettaDataType(value="ValuationReport", builder=ValuationReport.ValuationReportBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ValuationReport", model="fpml", builder=ValuationReport.ValuationReportBuilderImpl.class, version="2.1.1")
public interface ValuationReport extends NotificationMessage {

	ValuationReportMeta metaData = new ValuationReportMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Identifiers for the report instance and section.
	 *
	 */
	ReportIdentification getReportIdentification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specific characteristics included in the report.
	 *
	 */
	ReportContents getReportContents();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date for which this request was create.
	 *
	 */
	IdentifiedDate getAsOfDate();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time within the as-of date for which this report was created (i.e., the cut-off time of the report).
	 *
	 */
	LocalTime getAsOfTime();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The time this report was actually generated (i.e., the processing time of the report). This value, if present, will be no later than the message created time, and no earlier than any timestamp within a trade valuation item.
	 *
	 */
	ZonedDateTime getGeneratedDateTime();
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
	 * Provision A collection of data values describing the state of the given trade.
	 *
	 */
	List<? extends TradeValuationItem> getTradeValuationItem();

	/*********************** Build Methods  ***********************/
	ValuationReport build();
	
	ValuationReport.ValuationReportBuilder toBuilder();
	
	static ValuationReport.ValuationReportBuilder builder() {
		return new ValuationReport.ValuationReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationReport> getType() {
		return ValuationReport.class;
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
		processRosetta(path.newSubPath("reportIdentification"), processor, ReportIdentification.class, getReportIdentification());
		processRosetta(path.newSubPath("reportContents"), processor, ReportContents.class, getReportContents());
		processRosetta(path.newSubPath("asOfDate"), processor, IdentifiedDate.class, getAsOfDate());
		processor.processBasic(path.newSubPath("asOfTime"), LocalTime.class, getAsOfTime(), this);
		processor.processBasic(path.newSubPath("generatedDateTime"), ZonedDateTime.class, getGeneratedDateTime(), this);
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("market"), processor, Market.class, getMarket());
		processRosetta(path.newSubPath("portfolioValuationItem"), processor, PortfolioValuationItem.class, getPortfolioValuationItem());
		processRosetta(path.newSubPath("tradeValuationItem"), processor, TradeValuationItem.class, getTradeValuationItem());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationReportBuilder extends ValuationReport, NotificationMessage.NotificationMessageBuilder {
		ReportIdentification.ReportIdentificationBuilder getOrCreateReportIdentification();
		@Override
		ReportIdentification.ReportIdentificationBuilder getReportIdentification();
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
		ValuationReport.ValuationReportBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ValuationReport.ValuationReportBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ValuationReport.ValuationReportBuilder setActualBuild(Integer actualBuild);
		@Override
		ValuationReport.ValuationReportBuilder setHeader(NotificationMessageHeader header);
		@Override
		ValuationReport.ValuationReportBuilder addValidation(Validation validation);
		@Override
		ValuationReport.ValuationReportBuilder addValidation(Validation validation, int idx);
		@Override
		ValuationReport.ValuationReportBuilder addValidation(List<? extends Validation> validation);
		@Override
		ValuationReport.ValuationReportBuilder setValidation(List<? extends Validation> validation);
		@Override
		ValuationReport.ValuationReportBuilder setParentCorrelationId(CorrelationId parentCorrelationId);
		@Override
		ValuationReport.ValuationReportBuilder addCorrelationId(CorrelationId correlationId);
		@Override
		ValuationReport.ValuationReportBuilder addCorrelationId(CorrelationId correlationId, int idx);
		@Override
		ValuationReport.ValuationReportBuilder addCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ValuationReport.ValuationReportBuilder setCorrelationId(List<? extends CorrelationId> correlationId);
		@Override
		ValuationReport.ValuationReportBuilder setSequenceNumber(Integer sequenceNumber);
		@Override
		ValuationReport.ValuationReportBuilder addOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ValuationReport.ValuationReportBuilder addOnBehalfOf(OnBehalfOf onBehalfOf, int idx);
		@Override
		ValuationReport.ValuationReportBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		@Override
		ValuationReport.ValuationReportBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOf);
		ValuationReport.ValuationReportBuilder setReportIdentification(ReportIdentification reportIdentification);
		ValuationReport.ValuationReportBuilder setReportContents(ReportContents reportContents);
		ValuationReport.ValuationReportBuilder setAsOfDate(IdentifiedDate asOfDate);
		ValuationReport.ValuationReportBuilder setAsOfTime(LocalTime asOfTime);
		ValuationReport.ValuationReportBuilder setGeneratedDateTime(ZonedDateTime generatedDateTime);
		ValuationReport.ValuationReportBuilder addParty(Party party);
		ValuationReport.ValuationReportBuilder addParty(Party party, int idx);
		ValuationReport.ValuationReportBuilder addParty(List<? extends Party> party);
		ValuationReport.ValuationReportBuilder setParty(List<? extends Party> party);
		ValuationReport.ValuationReportBuilder addAccount(Account account);
		ValuationReport.ValuationReportBuilder addAccount(Account account, int idx);
		ValuationReport.ValuationReportBuilder addAccount(List<? extends Account> account);
		ValuationReport.ValuationReportBuilder setAccount(List<? extends Account> account);
		ValuationReport.ValuationReportBuilder setMarket(Market market);
		ValuationReport.ValuationReportBuilder addPortfolioValuationItem(PortfolioValuationItem portfolioValuationItem);
		ValuationReport.ValuationReportBuilder addPortfolioValuationItem(PortfolioValuationItem portfolioValuationItem, int idx);
		ValuationReport.ValuationReportBuilder addPortfolioValuationItem(List<? extends PortfolioValuationItem> portfolioValuationItem);
		ValuationReport.ValuationReportBuilder setPortfolioValuationItem(List<? extends PortfolioValuationItem> portfolioValuationItem);
		ValuationReport.ValuationReportBuilder addTradeValuationItem(TradeValuationItem tradeValuationItem);
		ValuationReport.ValuationReportBuilder addTradeValuationItem(TradeValuationItem tradeValuationItem, int idx);
		ValuationReport.ValuationReportBuilder addTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItem);
		ValuationReport.ValuationReportBuilder setTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItem);

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
			processRosetta(path.newSubPath("reportIdentification"), processor, ReportIdentification.ReportIdentificationBuilder.class, getReportIdentification());
			processRosetta(path.newSubPath("reportContents"), processor, ReportContents.ReportContentsBuilder.class, getReportContents());
			processRosetta(path.newSubPath("asOfDate"), processor, IdentifiedDate.IdentifiedDateBuilder.class, getAsOfDate());
			processor.processBasic(path.newSubPath("asOfTime"), LocalTime.class, getAsOfTime(), this);
			processor.processBasic(path.newSubPath("generatedDateTime"), ZonedDateTime.class, getGeneratedDateTime(), this);
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("market"), processor, Market.MarketBuilder.class, getMarket());
			processRosetta(path.newSubPath("portfolioValuationItem"), processor, PortfolioValuationItem.PortfolioValuationItemBuilder.class, getPortfolioValuationItem());
			processRosetta(path.newSubPath("tradeValuationItem"), processor, TradeValuationItem.TradeValuationItemBuilder.class, getTradeValuationItem());
		}
		

		ValuationReport.ValuationReportBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationReport  ***********************/
	class ValuationReportImpl extends NotificationMessage.NotificationMessageImpl implements ValuationReport {
		private final ReportIdentification reportIdentification;
		private final ReportContents reportContents;
		private final IdentifiedDate asOfDate;
		private final LocalTime asOfTime;
		private final ZonedDateTime generatedDateTime;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		private final Market market;
		private final List<? extends PortfolioValuationItem> portfolioValuationItem;
		private final List<? extends TradeValuationItem> tradeValuationItem;
		
		protected ValuationReportImpl(ValuationReport.ValuationReportBuilder builder) {
			super(builder);
			this.reportIdentification = ofNullable(builder.getReportIdentification()).map(f->f.build()).orElse(null);
			this.reportContents = ofNullable(builder.getReportContents()).map(f->f.build()).orElse(null);
			this.asOfDate = ofNullable(builder.getAsOfDate()).map(f->f.build()).orElse(null);
			this.asOfTime = builder.getAsOfTime();
			this.generatedDateTime = builder.getGeneratedDateTime();
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.market = ofNullable(builder.getMarket()).map(f->f.build()).orElse(null);
			this.portfolioValuationItem = ofNullable(builder.getPortfolioValuationItem()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.tradeValuationItem = ofNullable(builder.getTradeValuationItem()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportIdentification")
		public ReportIdentification getReportIdentification() {
			return reportIdentification;
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
		@RosettaAttribute("asOfTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfTime")
		public LocalTime getAsOfTime() {
			return asOfTime;
		}
		
		@Override
		@RosettaAttribute("generatedDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generatedDateTime")
		public ZonedDateTime getGeneratedDateTime() {
			return generatedDateTime;
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
		public ValuationReport build() {
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder toBuilder() {
			ValuationReport.ValuationReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationReport.ValuationReportBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportIdentification()).ifPresent(builder::setReportIdentification);
			ofNullable(getReportContents()).ifPresent(builder::setReportContents);
			ofNullable(getAsOfDate()).ifPresent(builder::setAsOfDate);
			ofNullable(getAsOfTime()).ifPresent(builder::setAsOfTime);
			ofNullable(getGeneratedDateTime()).ifPresent(builder::setGeneratedDateTime);
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
		
			ValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(reportIdentification, _that.getReportIdentification())) return false;
			if (!Objects.equals(reportContents, _that.getReportContents())) return false;
			if (!Objects.equals(asOfDate, _that.getAsOfDate())) return false;
			if (!Objects.equals(asOfTime, _that.getAsOfTime())) return false;
			if (!Objects.equals(generatedDateTime, _that.getGeneratedDateTime())) return false;
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
			_result = 31 * _result + (reportIdentification != null ? reportIdentification.hashCode() : 0);
			_result = 31 * _result + (reportContents != null ? reportContents.hashCode() : 0);
			_result = 31 * _result + (asOfDate != null ? asOfDate.hashCode() : 0);
			_result = 31 * _result + (asOfTime != null ? asOfTime.hashCode() : 0);
			_result = 31 * _result + (generatedDateTime != null ? generatedDateTime.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (market != null ? market.hashCode() : 0);
			_result = 31 * _result + (portfolioValuationItem != null ? portfolioValuationItem.hashCode() : 0);
			_result = 31 * _result + (tradeValuationItem != null ? tradeValuationItem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationReport {" +
				"reportIdentification=" + this.reportIdentification + ", " +
				"reportContents=" + this.reportContents + ", " +
				"asOfDate=" + this.asOfDate + ", " +
				"asOfTime=" + this.asOfTime + ", " +
				"generatedDateTime=" + this.generatedDateTime + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"market=" + this.market + ", " +
				"portfolioValuationItem=" + this.portfolioValuationItem + ", " +
				"tradeValuationItem=" + this.tradeValuationItem +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationReport  ***********************/
	class ValuationReportBuilderImpl extends NotificationMessage.NotificationMessageBuilderImpl implements ValuationReport.ValuationReportBuilder {
	
		protected ReportIdentification.ReportIdentificationBuilder reportIdentification;
		protected ReportContents.ReportContentsBuilder reportContents;
		protected IdentifiedDate.IdentifiedDateBuilder asOfDate;
		protected LocalTime asOfTime;
		protected ZonedDateTime generatedDateTime;
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		protected Market.MarketBuilder market;
		protected List<PortfolioValuationItem.PortfolioValuationItemBuilder> portfolioValuationItem = new ArrayList<>();
		protected List<TradeValuationItem.TradeValuationItemBuilder> tradeValuationItem = new ArrayList<>();
		
		@Override
		@RosettaAttribute("reportIdentification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("reportIdentification")
		public ReportIdentification.ReportIdentificationBuilder getReportIdentification() {
			return reportIdentification;
		}
		
		@Override
		public ReportIdentification.ReportIdentificationBuilder getOrCreateReportIdentification() {
			ReportIdentification.ReportIdentificationBuilder result;
			if (reportIdentification!=null) {
				result = reportIdentification;
			}
			else {
				result = reportIdentification = ReportIdentification.builder();
			}
			
			return result;
		}
		
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
		@RosettaAttribute("asOfTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("asOfTime")
		public LocalTime getAsOfTime() {
			return asOfTime;
		}
		
		@Override
		@RosettaAttribute("generatedDateTime")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("generatedDateTime")
		public ZonedDateTime getGeneratedDateTime() {
			return generatedDateTime;
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
		public ValuationReport.ValuationReportBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ValuationReport.ValuationReportBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ValuationReport.ValuationReportBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public ValuationReport.ValuationReportBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ValuationReport.ValuationReportBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addValidation(List<? extends Validation> validations) {
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
		public ValuationReport.ValuationReportBuilder setValidation(List<? extends Validation> validations) {
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
		public ValuationReport.ValuationReportBuilder setParentCorrelationId(CorrelationId _parentCorrelationId) {
			this.parentCorrelationId = _parentCorrelationId == null ? null : _parentCorrelationId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("correlationId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("correlationId")
		@Override
		public ValuationReport.ValuationReportBuilder addCorrelationId(CorrelationId _correlationId) {
			if (_correlationId != null) {
				this.correlationId.add(_correlationId.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addCorrelationId(CorrelationId _correlationId, int idx) {
			getIndex(this.correlationId, idx, () -> _correlationId.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ValuationReport.ValuationReportBuilder setCorrelationId(List<? extends CorrelationId> correlationIds) {
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
		public ValuationReport.ValuationReportBuilder setSequenceNumber(Integer _sequenceNumber) {
			this.sequenceNumber = _sequenceNumber == null ? null : _sequenceNumber;
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("onBehalfOf")
		@Override
		public ValuationReport.ValuationReportBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf) {
			if (_onBehalfOf != null) {
				this.onBehalfOf.add(_onBehalfOf.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addOnBehalfOf(OnBehalfOf _onBehalfOf, int idx) {
			getIndex(this.onBehalfOf, idx, () -> _onBehalfOf.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
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
		public ValuationReport.ValuationReportBuilder setOnBehalfOf(List<? extends OnBehalfOf> onBehalfOfs) {
			if (onBehalfOfs == null) {
				this.onBehalfOf = new ArrayList<>();
			} else {
				this.onBehalfOf = onBehalfOfs.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("reportIdentification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportIdentification")
		@Override
		public ValuationReport.ValuationReportBuilder setReportIdentification(ReportIdentification _reportIdentification) {
			this.reportIdentification = _reportIdentification == null ? null : _reportIdentification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportContents")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("reportContents")
		@Override
		public ValuationReport.ValuationReportBuilder setReportContents(ReportContents _reportContents) {
			this.reportContents = _reportContents == null ? null : _reportContents.toBuilder();
			return this;
		}
		
		@RosettaAttribute("asOfDate")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asOfDate")
		@Override
		public ValuationReport.ValuationReportBuilder setAsOfDate(IdentifiedDate _asOfDate) {
			this.asOfDate = _asOfDate == null ? null : _asOfDate.toBuilder();
			return this;
		}
		
		@RosettaAttribute("asOfTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("asOfTime")
		@Override
		public ValuationReport.ValuationReportBuilder setAsOfTime(LocalTime _asOfTime) {
			this.asOfTime = _asOfTime == null ? null : _asOfTime;
			return this;
		}
		
		@RosettaAttribute("generatedDateTime")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("generatedDateTime")
		@Override
		public ValuationReport.ValuationReportBuilder setGeneratedDateTime(ZonedDateTime _generatedDateTime) {
			this.generatedDateTime = _generatedDateTime == null ? null : _generatedDateTime;
			return this;
		}
		
		@RosettaAttribute("party")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("party")
		@Override
		public ValuationReport.ValuationReportBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addParty(List<? extends Party> partys) {
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
		public ValuationReport.ValuationReportBuilder setParty(List<? extends Party> partys) {
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
		public ValuationReport.ValuationReportBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addAccount(List<? extends Account> accounts) {
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
		public ValuationReport.ValuationReportBuilder setAccount(List<? extends Account> accounts) {
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
		public ValuationReport.ValuationReportBuilder setMarket(Market _market) {
			this.market = _market == null ? null : _market.toBuilder();
			return this;
		}
		
		@RosettaAttribute("portfolioValuationItem")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("portfolioValuationItem")
		@Override
		public ValuationReport.ValuationReportBuilder addPortfolioValuationItem(PortfolioValuationItem _portfolioValuationItem) {
			if (_portfolioValuationItem != null) {
				this.portfolioValuationItem.add(_portfolioValuationItem.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addPortfolioValuationItem(PortfolioValuationItem _portfolioValuationItem, int idx) {
			getIndex(this.portfolioValuationItem, idx, () -> _portfolioValuationItem.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addPortfolioValuationItem(List<? extends PortfolioValuationItem> portfolioValuationItems) {
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
		public ValuationReport.ValuationReportBuilder setPortfolioValuationItem(List<? extends PortfolioValuationItem> portfolioValuationItems) {
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
		public ValuationReport.ValuationReportBuilder addTradeValuationItem(TradeValuationItem _tradeValuationItem) {
			if (_tradeValuationItem != null) {
				this.tradeValuationItem.add(_tradeValuationItem.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addTradeValuationItem(TradeValuationItem _tradeValuationItem, int idx) {
			getIndex(this.tradeValuationItem, idx, () -> _tradeValuationItem.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder addTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItems) {
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
		public ValuationReport.ValuationReportBuilder setTradeValuationItem(List<? extends TradeValuationItem> tradeValuationItems) {
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
		public ValuationReport build() {
			return new ValuationReport.ValuationReportImpl(this);
		}
		
		@Override
		public ValuationReport.ValuationReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationReport.ValuationReportBuilder prune() {
			super.prune();
			if (reportIdentification!=null && !reportIdentification.prune().hasData()) reportIdentification = null;
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
			if (getReportIdentification()!=null && getReportIdentification().hasData()) return true;
			if (getReportContents()!=null && getReportContents().hasData()) return true;
			if (getAsOfDate()!=null && getAsOfDate().hasData()) return true;
			if (getAsOfTime()!=null) return true;
			if (getGeneratedDateTime()!=null) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getMarket()!=null && getMarket().hasData()) return true;
			if (getPortfolioValuationItem()!=null && getPortfolioValuationItem().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getTradeValuationItem()!=null && getTradeValuationItem().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationReport.ValuationReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ValuationReport.ValuationReportBuilder o = (ValuationReport.ValuationReportBuilder) other;
			
			merger.mergeRosetta(getReportIdentification(), o.getReportIdentification(), this::setReportIdentification);
			merger.mergeRosetta(getReportContents(), o.getReportContents(), this::setReportContents);
			merger.mergeRosetta(getAsOfDate(), o.getAsOfDate(), this::setAsOfDate);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			merger.mergeRosetta(getMarket(), o.getMarket(), this::setMarket);
			merger.mergeRosetta(getPortfolioValuationItem(), o.getPortfolioValuationItem(), this::getOrCreatePortfolioValuationItem);
			merger.mergeRosetta(getTradeValuationItem(), o.getTradeValuationItem(), this::getOrCreateTradeValuationItem);
			
			merger.mergeBasic(getAsOfTime(), o.getAsOfTime(), this::setAsOfTime);
			merger.mergeBasic(getGeneratedDateTime(), o.getGeneratedDateTime(), this::setGeneratedDateTime);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationReport _that = getType().cast(o);
		
			if (!Objects.equals(reportIdentification, _that.getReportIdentification())) return false;
			if (!Objects.equals(reportContents, _that.getReportContents())) return false;
			if (!Objects.equals(asOfDate, _that.getAsOfDate())) return false;
			if (!Objects.equals(asOfTime, _that.getAsOfTime())) return false;
			if (!Objects.equals(generatedDateTime, _that.getGeneratedDateTime())) return false;
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
			_result = 31 * _result + (reportIdentification != null ? reportIdentification.hashCode() : 0);
			_result = 31 * _result + (reportContents != null ? reportContents.hashCode() : 0);
			_result = 31 * _result + (asOfDate != null ? asOfDate.hashCode() : 0);
			_result = 31 * _result + (asOfTime != null ? asOfTime.hashCode() : 0);
			_result = 31 * _result + (generatedDateTime != null ? generatedDateTime.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (market != null ? market.hashCode() : 0);
			_result = 31 * _result + (portfolioValuationItem != null ? portfolioValuationItem.hashCode() : 0);
			_result = 31 * _result + (tradeValuationItem != null ? tradeValuationItem.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationReportBuilder {" +
				"reportIdentification=" + this.reportIdentification + ", " +
				"reportContents=" + this.reportContents + ", " +
				"asOfDate=" + this.asOfDate + ", " +
				"asOfTime=" + this.asOfTime + ", " +
				"generatedDateTime=" + this.generatedDateTime + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"market=" + this.market + ", " +
				"portfolioValuationItem=" + this.portfolioValuationItem + ", " +
				"tradeValuationItem=" + this.tradeValuationItem +
			'}' + " " + super.toString();
		}
	}
}
