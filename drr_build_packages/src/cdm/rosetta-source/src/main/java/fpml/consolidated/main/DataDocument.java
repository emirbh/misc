package fpml.consolidated.main;

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
import fpml.consolidated.doc.Document;
import fpml.consolidated.doc.Portfolio;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.main.meta.DataDocumentMeta;
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
 * version "recordkeeping-5.13"
 *
 * Provision A type defining a content model that is backwards compatible with older FpML releases and which can be used to contain sets of data without expressing any processing intention.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a content model that is backwards compatible with older FpML releases and which can be used to contain sets of data without expressing any processing intention.
 *
 */
@RosettaDataType(value="DataDocument", builder=DataDocument.DataDocumentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="DataDocument", model="fpml", builder=DataDocument.DataDocumentBuilderImpl.class, version="2.1.1")
public interface DataDocument extends Document {

	DataDocumentMeta metaData = new DataDocumentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A list of validation sets the sender asserts the document is valid with respect to.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of validation sets the sender asserts the document is valid with respect to.
	 *
	 */
	List<? extends Validation> getValidation();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates which party (and accounts) a trade is being processed for.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates which party (and accounts) a trade is being processed for.
	 *
	 */
	OnBehalfOf getOnBehalfOf();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision The root element in an FpML trade document.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The root element in an FpML trade document.
	 *
	 */
	List<? extends Trade> getTrade();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A legal entity or a subdivision of a legal entity. Parties can perform multiple roles in a trade lifecycle. For example, the principal parties obligated to make payments from time to time during the term of the trade, but may include other parties involved in, or incidental to, the trade, such as parties acting in the role of novation transferor/transferee, broker, calculation agent, etc. In FpML roles are defined in multiple places within a document.
	 *
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
	 * version "recordkeeping-5.13"
	 *
	 * Provision Optional account information used to precisely define the origination and destination of financial instruments.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Optional account information used to precisely define the origination and destination of financial instruments.
	 *
	 */
	List<? extends Account> getAccount();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision An arbitary grouping of trade references (and possibly other portfolios).
	 *
	 */
	List<? extends Portfolio> getPortfolio();

	/*********************** Build Methods  ***********************/
	DataDocument build();
	
	DataDocument.DataDocumentBuilder toBuilder();
	
	static DataDocument.DataDocumentBuilder builder() {
		return new DataDocument.DataDocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends DataDocument> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends DataDocument> getType() {
		return DataDocument.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
		processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.class, getOnBehalfOf());
		processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.class, getOriginatingEvent());
		processRosetta(path.newSubPath("trade"), processor, Trade.class, getTrade());
		processRosetta(path.newSubPath("party"), processor, Party.class, getParty());
		processRosetta(path.newSubPath("account"), processor, Account.class, getAccount());
		processRosetta(path.newSubPath("portfolio"), processor, Portfolio.class, getPortfolio());
	}
	

	/*********************** Builder Interface  ***********************/
	interface DataDocumentBuilder extends DataDocument, Document.DocumentBuilder {
		Validation.ValidationBuilder getOrCreateValidation(int index);
		@Override
		List<? extends Validation.ValidationBuilder> getValidation();
		OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf();
		@Override
		OnBehalfOf.OnBehalfOfBuilder getOnBehalfOf();
		OriginatingEvent.OriginatingEventBuilder getOrCreateOriginatingEvent();
		@Override
		OriginatingEvent.OriginatingEventBuilder getOriginatingEvent();
		Trade.TradeBuilder getOrCreateTrade(int index);
		@Override
		List<? extends Trade.TradeBuilder> getTrade();
		Party.PartyBuilder getOrCreateParty(int index);
		@Override
		List<? extends Party.PartyBuilder> getParty();
		Account.AccountBuilder getOrCreateAccount(int index);
		@Override
		List<? extends Account.AccountBuilder> getAccount();
		Portfolio.PortfolioBuilder getOrCreatePortfolio(int index);
		@Override
		List<? extends Portfolio.PortfolioBuilder> getPortfolio();
		@Override
		DataDocument.DataDocumentBuilder setFpmlVersion(String fpmlVersion);
		@Override
		DataDocument.DataDocumentBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		DataDocument.DataDocumentBuilder setActualBuild(Integer actualBuild);
		DataDocument.DataDocumentBuilder addValidation(Validation validation);
		DataDocument.DataDocumentBuilder addValidation(Validation validation, int idx);
		DataDocument.DataDocumentBuilder addValidation(List<? extends Validation> validation);
		DataDocument.DataDocumentBuilder setValidation(List<? extends Validation> validation);
		DataDocument.DataDocumentBuilder setOnBehalfOf(OnBehalfOf onBehalfOf);
		DataDocument.DataDocumentBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		DataDocument.DataDocumentBuilder addTrade(Trade trade);
		DataDocument.DataDocumentBuilder addTrade(Trade trade, int idx);
		DataDocument.DataDocumentBuilder addTrade(List<? extends Trade> trade);
		DataDocument.DataDocumentBuilder setTrade(List<? extends Trade> trade);
		DataDocument.DataDocumentBuilder addParty(Party party);
		DataDocument.DataDocumentBuilder addParty(Party party, int idx);
		DataDocument.DataDocumentBuilder addParty(List<? extends Party> party);
		DataDocument.DataDocumentBuilder setParty(List<? extends Party> party);
		DataDocument.DataDocumentBuilder addAccount(Account account);
		DataDocument.DataDocumentBuilder addAccount(Account account, int idx);
		DataDocument.DataDocumentBuilder addAccount(List<? extends Account> account);
		DataDocument.DataDocumentBuilder setAccount(List<? extends Account> account);
		DataDocument.DataDocumentBuilder addPortfolio(Portfolio portfolio);
		DataDocument.DataDocumentBuilder addPortfolio(Portfolio portfolio, int idx);
		DataDocument.DataDocumentBuilder addPortfolio(List<? extends Portfolio> portfolio);
		DataDocument.DataDocumentBuilder setPortfolio(List<? extends Portfolio> portfolio);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
			processRosetta(path.newSubPath("onBehalfOf"), processor, OnBehalfOf.OnBehalfOfBuilder.class, getOnBehalfOf());
			processRosetta(path.newSubPath("originatingEvent"), processor, OriginatingEvent.OriginatingEventBuilder.class, getOriginatingEvent());
			processRosetta(path.newSubPath("trade"), processor, Trade.TradeBuilder.class, getTrade());
			processRosetta(path.newSubPath("party"), processor, Party.PartyBuilder.class, getParty());
			processRosetta(path.newSubPath("account"), processor, Account.AccountBuilder.class, getAccount());
			processRosetta(path.newSubPath("portfolio"), processor, Portfolio.PortfolioBuilder.class, getPortfolio());
		}
		

		DataDocument.DataDocumentBuilder prune();
	}

	/*********************** Immutable Implementation of DataDocument  ***********************/
	class DataDocumentImpl extends Document.DocumentImpl implements DataDocument {
		private final List<? extends Validation> validation;
		private final OnBehalfOf onBehalfOf;
		private final OriginatingEvent originatingEvent;
		private final List<? extends Trade> trade;
		private final List<? extends Party> party;
		private final List<? extends Account> account;
		private final List<? extends Portfolio> portfolio;
		
		protected DataDocumentImpl(DataDocument.DataDocumentBuilder builder) {
			super(builder);
			this.validation = ofNullable(builder.getValidation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.onBehalfOf = ofNullable(builder.getOnBehalfOf()).map(f->f.build()).orElse(null);
			this.originatingEvent = ofNullable(builder.getOriginatingEvent()).map(f->f.build()).orElse(null);
			this.trade = ofNullable(builder.getTrade()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.party = ofNullable(builder.getParty()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.account = ofNullable(builder.getAccount()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.portfolio = ofNullable(builder.getPortfolio()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("validation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("validation")
		public List<? extends Validation> getValidation() {
			return validation;
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("onBehalfOf")
		public OnBehalfOf getOnBehalfOf() {
			return onBehalfOf;
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
		@Multi
		@RuneAttribute("trade")
		public List<? extends Trade> getTrade() {
			return trade;
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
		@RosettaAttribute("portfolio")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("portfolio")
		public List<? extends Portfolio> getPortfolio() {
			return portfolio;
		}
		
		@Override
		public DataDocument build() {
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder toBuilder() {
			DataDocument.DataDocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DataDocument.DataDocumentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getValidation()).ifPresent(builder::setValidation);
			ofNullable(getOnBehalfOf()).ifPresent(builder::setOnBehalfOf);
			ofNullable(getOriginatingEvent()).ifPresent(builder::setOriginatingEvent);
			ofNullable(getTrade()).ifPresent(builder::setTrade);
			ofNullable(getParty()).ifPresent(builder::setParty);
			ofNullable(getAccount()).ifPresent(builder::setAccount);
			ofNullable(getPortfolio()).ifPresent(builder::setPortfolio);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DataDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!ListEquals.listEquals(portfolio, _that.getPortfolio())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataDocument {" +
				"validation=" + this.validation + ", " +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"portfolio=" + this.portfolio +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of DataDocument  ***********************/
	class DataDocumentBuilderImpl extends Document.DocumentBuilderImpl implements DataDocument.DataDocumentBuilder {
	
		protected List<Validation.ValidationBuilder> validation = new ArrayList<>();
		protected OnBehalfOf.OnBehalfOfBuilder onBehalfOf;
		protected OriginatingEvent.OriginatingEventBuilder originatingEvent;
		protected List<Trade.TradeBuilder> trade = new ArrayList<>();
		protected List<Party.PartyBuilder> party = new ArrayList<>();
		protected List<Account.AccountBuilder> account = new ArrayList<>();
		protected List<Portfolio.PortfolioBuilder> portfolio = new ArrayList<>();
		
		@Override
		@RosettaAttribute("validation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("validation")
		public List<? extends Validation.ValidationBuilder> getValidation() {
			return validation;
		}
		
		@Override
		public Validation.ValidationBuilder getOrCreateValidation(int index) {
			if (validation==null) {
				this.validation = new ArrayList<>();
			}
			return getIndex(validation, index, () -> {
						Validation.ValidationBuilder newValidation = Validation.builder();
						return newValidation;
					});
		}
		
		@Override
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("onBehalfOf")
		public OnBehalfOf.OnBehalfOfBuilder getOnBehalfOf() {
			return onBehalfOf;
		}
		
		@Override
		public OnBehalfOf.OnBehalfOfBuilder getOrCreateOnBehalfOf() {
			OnBehalfOf.OnBehalfOfBuilder result;
			if (onBehalfOf!=null) {
				result = onBehalfOf;
			}
			else {
				result = onBehalfOf = OnBehalfOf.builder();
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
		@Multi
		@RuneAttribute("trade")
		public List<? extends Trade.TradeBuilder> getTrade() {
			return trade;
		}
		
		@Override
		public Trade.TradeBuilder getOrCreateTrade(int index) {
			if (trade==null) {
				this.trade = new ArrayList<>();
			}
			return getIndex(trade, index, () -> {
						Trade.TradeBuilder newTrade = Trade.builder();
						return newTrade;
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
		
		@Override
		@RosettaAttribute("portfolio")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("portfolio")
		public List<? extends Portfolio.PortfolioBuilder> getPortfolio() {
			return portfolio;
		}
		
		@Override
		public Portfolio.PortfolioBuilder getOrCreatePortfolio(int index) {
			if (portfolio==null) {
				this.portfolio = new ArrayList<>();
			}
			return getIndex(portfolio, index, () -> {
						Portfolio.PortfolioBuilder newPortfolio = Portfolio.builder();
						return newPortfolio;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public DataDocument.DataDocumentBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public DataDocument.DataDocumentBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public DataDocument.DataDocumentBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public DataDocument.DataDocumentBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addValidation(List<? extends Validation> validations) {
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
		public DataDocument.DataDocumentBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("onBehalfOf")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("onBehalfOf")
		@Override
		public DataDocument.DataDocumentBuilder setOnBehalfOf(OnBehalfOf _onBehalfOf) {
			this.onBehalfOf = _onBehalfOf == null ? null : _onBehalfOf.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public DataDocument.DataDocumentBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("trade")
		@Override
		public DataDocument.DataDocumentBuilder addTrade(Trade _trade) {
			if (_trade != null) {
				this.trade.add(_trade.toBuilder());
			}
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addTrade(Trade _trade, int idx) {
			getIndex(this.trade, idx, () -> _trade.toBuilder());
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addTrade(List<? extends Trade> trades) {
			if (trades != null) {
				for (final Trade toAdd : trades) {
					this.trade.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("trade")
		@Override
		public DataDocument.DataDocumentBuilder setTrade(List<? extends Trade> trades) {
			if (trades == null) {
				this.trade = new ArrayList<>();
			} else {
				this.trade = trades.stream()
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
		public DataDocument.DataDocumentBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addParty(List<? extends Party> partys) {
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
		public DataDocument.DataDocumentBuilder setParty(List<? extends Party> partys) {
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
		public DataDocument.DataDocumentBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addAccount(List<? extends Account> accounts) {
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
		public DataDocument.DataDocumentBuilder setAccount(List<? extends Account> accounts) {
			if (accounts == null) {
				this.account = new ArrayList<>();
			} else {
				this.account = accounts.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("portfolio")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("portfolio")
		@Override
		public DataDocument.DataDocumentBuilder addPortfolio(Portfolio _portfolio) {
			if (_portfolio != null) {
				this.portfolio.add(_portfolio.toBuilder());
			}
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addPortfolio(Portfolio _portfolio, int idx) {
			getIndex(this.portfolio, idx, () -> _portfolio.toBuilder());
			return this;
		}
		
		@Override
		public DataDocument.DataDocumentBuilder addPortfolio(List<? extends Portfolio> portfolios) {
			if (portfolios != null) {
				for (final Portfolio toAdd : portfolios) {
					this.portfolio.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("portfolio")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("portfolio")
		@Override
		public DataDocument.DataDocumentBuilder setPortfolio(List<? extends Portfolio> portfolios) {
			if (portfolios == null) {
				this.portfolio = new ArrayList<>();
			} else {
				this.portfolio = portfolios.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public DataDocument build() {
			return new DataDocument.DataDocumentImpl(this);
		}
		
		@Override
		public DataDocument.DataDocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataDocument.DataDocumentBuilder prune() {
			super.prune();
			validation = validation.stream().filter(b->b!=null).<Validation.ValidationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (onBehalfOf!=null && !onBehalfOf.prune().hasData()) onBehalfOf = null;
			if (originatingEvent!=null && !originatingEvent.prune().hasData()) originatingEvent = null;
			trade = trade.stream().filter(b->b!=null).<Trade.TradeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			party = party.stream().filter(b->b!=null).<Party.PartyBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			account = account.stream().filter(b->b!=null).<Account.AccountBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			portfolio = portfolio.stream().filter(b->b!=null).<Portfolio.PortfolioBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getValidation()!=null && getValidation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getOnBehalfOf()!=null && getOnBehalfOf().hasData()) return true;
			if (getOriginatingEvent()!=null && getOriginatingEvent().hasData()) return true;
			if (getTrade()!=null && getTrade().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getParty()!=null && getParty().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAccount()!=null && getAccount().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPortfolio()!=null && getPortfolio().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DataDocument.DataDocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			DataDocument.DataDocumentBuilder o = (DataDocument.DataDocumentBuilder) other;
			
			merger.mergeRosetta(getValidation(), o.getValidation(), this::getOrCreateValidation);
			merger.mergeRosetta(getOnBehalfOf(), o.getOnBehalfOf(), this::setOnBehalfOf);
			merger.mergeRosetta(getOriginatingEvent(), o.getOriginatingEvent(), this::setOriginatingEvent);
			merger.mergeRosetta(getTrade(), o.getTrade(), this::getOrCreateTrade);
			merger.mergeRosetta(getParty(), o.getParty(), this::getOrCreateParty);
			merger.mergeRosetta(getAccount(), o.getAccount(), this::getOrCreateAccount);
			merger.mergeRosetta(getPortfolio(), o.getPortfolio(), this::getOrCreatePortfolio);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			DataDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			if (!Objects.equals(onBehalfOf, _that.getOnBehalfOf())) return false;
			if (!Objects.equals(originatingEvent, _that.getOriginatingEvent())) return false;
			if (!ListEquals.listEquals(trade, _that.getTrade())) return false;
			if (!ListEquals.listEquals(party, _that.getParty())) return false;
			if (!ListEquals.listEquals(account, _that.getAccount())) return false;
			if (!ListEquals.listEquals(portfolio, _that.getPortfolio())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			_result = 31 * _result + (onBehalfOf != null ? onBehalfOf.hashCode() : 0);
			_result = 31 * _result + (originatingEvent != null ? originatingEvent.hashCode() : 0);
			_result = 31 * _result + (trade != null ? trade.hashCode() : 0);
			_result = 31 * _result + (party != null ? party.hashCode() : 0);
			_result = 31 * _result + (account != null ? account.hashCode() : 0);
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DataDocumentBuilder {" +
				"validation=" + this.validation + ", " +
				"onBehalfOf=" + this.onBehalfOf + ", " +
				"originatingEvent=" + this.originatingEvent + ", " +
				"trade=" + this.trade + ", " +
				"party=" + this.party + ", " +
				"account=" + this.account + ", " +
				"portfolio=" + this.portfolio +
			'}' + " " + super.toString();
		}
	}
}
