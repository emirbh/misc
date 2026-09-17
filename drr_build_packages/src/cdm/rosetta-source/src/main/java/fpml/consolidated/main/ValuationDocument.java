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
import fpml.consolidated.doc.Portfolio;
import fpml.consolidated.doc.Trade;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.main.meta.ValuationDocumentMeta;
import fpml.consolidated.riskdef.Market;
import fpml.consolidated.shared.Account;
import fpml.consolidated.shared.OnBehalfOf;
import fpml.consolidated.shared.OriginatingEvent;
import fpml.consolidated.shared.Party;
import fpml.consolidated.valuation.ValuationSet;
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
 * Provision A type defining a content model that includes valuation (pricing and risk) data without expressing any processing intention.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining a content model that includes valuation (pricing and risk) data without expressing any processing intention.
 *
 */
@RosettaDataType(value="ValuationDocument", builder=ValuationDocument.ValuationDocumentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ValuationDocument", model="fpml", builder=ValuationDocument.ValuationDocumentBuilderImpl.class, version="2.1.1")
public interface ValuationDocument extends DataDocument {

	ValuationDocumentMeta metaData = new ValuationDocumentMeta();

	/*********************** Getter Methods  ***********************/
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
	List<? extends Market> getMarket();
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
	List<? extends ValuationSet> getValuationSet();

	/*********************** Build Methods  ***********************/
	ValuationDocument build();
	
	ValuationDocument.ValuationDocumentBuilder toBuilder();
	
	static ValuationDocument.ValuationDocumentBuilder builder() {
		return new ValuationDocument.ValuationDocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationDocument> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationDocument> getType() {
		return ValuationDocument.class;
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
		processRosetta(path.newSubPath("market"), processor, Market.class, getMarket());
		processRosetta(path.newSubPath("valuationSet"), processor, ValuationSet.class, getValuationSet());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationDocumentBuilder extends ValuationDocument, DataDocument.DataDocumentBuilder {
		Market.MarketBuilder getOrCreateMarket(int index);
		@Override
		List<? extends Market.MarketBuilder> getMarket();
		ValuationSet.ValuationSetBuilder getOrCreateValuationSet(int index);
		@Override
		List<? extends ValuationSet.ValuationSetBuilder> getValuationSet();
		@Override
		ValuationDocument.ValuationDocumentBuilder setFpmlVersion(String fpmlVersion);
		@Override
		ValuationDocument.ValuationDocumentBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		ValuationDocument.ValuationDocumentBuilder setActualBuild(Integer actualBuild);
		@Override
		ValuationDocument.ValuationDocumentBuilder addValidation(Validation validation);
		@Override
		ValuationDocument.ValuationDocumentBuilder addValidation(Validation validation, int idx);
		@Override
		ValuationDocument.ValuationDocumentBuilder addValidation(List<? extends Validation> validation);
		@Override
		ValuationDocument.ValuationDocumentBuilder setValidation(List<? extends Validation> validation);
		@Override
		ValuationDocument.ValuationDocumentBuilder setOnBehalfOf(OnBehalfOf onBehalfOf);
		@Override
		ValuationDocument.ValuationDocumentBuilder setOriginatingEvent(OriginatingEvent originatingEvent);
		@Override
		ValuationDocument.ValuationDocumentBuilder addTrade(Trade trade);
		@Override
		ValuationDocument.ValuationDocumentBuilder addTrade(Trade trade, int idx);
		@Override
		ValuationDocument.ValuationDocumentBuilder addTrade(List<? extends Trade> trade);
		@Override
		ValuationDocument.ValuationDocumentBuilder setTrade(List<? extends Trade> trade);
		@Override
		ValuationDocument.ValuationDocumentBuilder addParty(Party party);
		@Override
		ValuationDocument.ValuationDocumentBuilder addParty(Party party, int idx);
		@Override
		ValuationDocument.ValuationDocumentBuilder addParty(List<? extends Party> party);
		@Override
		ValuationDocument.ValuationDocumentBuilder setParty(List<? extends Party> party);
		@Override
		ValuationDocument.ValuationDocumentBuilder addAccount(Account account);
		@Override
		ValuationDocument.ValuationDocumentBuilder addAccount(Account account, int idx);
		@Override
		ValuationDocument.ValuationDocumentBuilder addAccount(List<? extends Account> account);
		@Override
		ValuationDocument.ValuationDocumentBuilder setAccount(List<? extends Account> account);
		@Override
		ValuationDocument.ValuationDocumentBuilder addPortfolio(Portfolio portfolio);
		@Override
		ValuationDocument.ValuationDocumentBuilder addPortfolio(Portfolio portfolio, int idx);
		@Override
		ValuationDocument.ValuationDocumentBuilder addPortfolio(List<? extends Portfolio> portfolio);
		@Override
		ValuationDocument.ValuationDocumentBuilder setPortfolio(List<? extends Portfolio> portfolio);
		ValuationDocument.ValuationDocumentBuilder addMarket(Market market);
		ValuationDocument.ValuationDocumentBuilder addMarket(Market market, int idx);
		ValuationDocument.ValuationDocumentBuilder addMarket(List<? extends Market> market);
		ValuationDocument.ValuationDocumentBuilder setMarket(List<? extends Market> market);
		ValuationDocument.ValuationDocumentBuilder addValuationSet(ValuationSet valuationSet);
		ValuationDocument.ValuationDocumentBuilder addValuationSet(ValuationSet valuationSet, int idx);
		ValuationDocument.ValuationDocumentBuilder addValuationSet(List<? extends ValuationSet> valuationSet);
		ValuationDocument.ValuationDocumentBuilder setValuationSet(List<? extends ValuationSet> valuationSet);

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
			processRosetta(path.newSubPath("market"), processor, Market.MarketBuilder.class, getMarket());
			processRosetta(path.newSubPath("valuationSet"), processor, ValuationSet.ValuationSetBuilder.class, getValuationSet());
		}
		

		ValuationDocument.ValuationDocumentBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationDocument  ***********************/
	class ValuationDocumentImpl extends DataDocument.DataDocumentImpl implements ValuationDocument {
		private final List<? extends Market> market;
		private final List<? extends ValuationSet> valuationSet;
		
		protected ValuationDocumentImpl(ValuationDocument.ValuationDocumentBuilder builder) {
			super(builder);
			this.market = ofNullable(builder.getMarket()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.valuationSet = ofNullable(builder.getValuationSet()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("market")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("market")
		public List<? extends Market> getMarket() {
			return market;
		}
		
		@Override
		@RosettaAttribute("valuationSet")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationSet")
		public List<? extends ValuationSet> getValuationSet() {
			return valuationSet;
		}
		
		@Override
		public ValuationDocument build() {
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder toBuilder() {
			ValuationDocument.ValuationDocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationDocument.ValuationDocumentBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getMarket()).ifPresent(builder::setMarket);
			ofNullable(getValuationSet()).ifPresent(builder::setValuationSet);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(market, _that.getMarket())) return false;
			if (!ListEquals.listEquals(valuationSet, _that.getValuationSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (market != null ? market.hashCode() : 0);
			_result = 31 * _result + (valuationSet != null ? valuationSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDocument {" +
				"market=" + this.market + ", " +
				"valuationSet=" + this.valuationSet +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationDocument  ***********************/
	class ValuationDocumentBuilderImpl extends DataDocument.DataDocumentBuilderImpl implements ValuationDocument.ValuationDocumentBuilder {
	
		protected List<Market.MarketBuilder> market = new ArrayList<>();
		protected List<ValuationSet.ValuationSetBuilder> valuationSet = new ArrayList<>();
		
		@Override
		@RosettaAttribute("market")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("market")
		public List<? extends Market.MarketBuilder> getMarket() {
			return market;
		}
		
		@Override
		public Market.MarketBuilder getOrCreateMarket(int index) {
			if (market==null) {
				this.market = new ArrayList<>();
			}
			return getIndex(market, index, () -> {
						Market.MarketBuilder newMarket = Market.builder();
						return newMarket;
					});
		}
		
		@Override
		@RosettaAttribute("valuationSet")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("valuationSet")
		public List<? extends ValuationSet.ValuationSetBuilder> getValuationSet() {
			return valuationSet;
		}
		
		@Override
		public ValuationSet.ValuationSetBuilder getOrCreateValuationSet(int index) {
			if (valuationSet==null) {
				this.valuationSet = new ArrayList<>();
			}
			return getIndex(valuationSet, index, () -> {
						ValuationSet.ValuationSetBuilder newValuationSet = ValuationSet.builder();
						return newValuationSet;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public ValuationDocument.ValuationDocumentBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public ValuationDocument.ValuationDocumentBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public ValuationDocument.ValuationDocumentBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public ValuationDocument.ValuationDocumentBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addValidation(List<? extends Validation> validations) {
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
		public ValuationDocument.ValuationDocumentBuilder setValidation(List<? extends Validation> validations) {
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
		public ValuationDocument.ValuationDocumentBuilder setOnBehalfOf(OnBehalfOf _onBehalfOf) {
			this.onBehalfOf = _onBehalfOf == null ? null : _onBehalfOf.toBuilder();
			return this;
		}
		
		@RosettaAttribute("originatingEvent")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originatingEvent")
		@Override
		public ValuationDocument.ValuationDocumentBuilder setOriginatingEvent(OriginatingEvent _originatingEvent) {
			this.originatingEvent = _originatingEvent == null ? null : _originatingEvent.toBuilder();
			return this;
		}
		
		@RosettaAttribute("trade")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("trade")
		@Override
		public ValuationDocument.ValuationDocumentBuilder addTrade(Trade _trade) {
			if (_trade != null) {
				this.trade.add(_trade.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addTrade(Trade _trade, int idx) {
			getIndex(this.trade, idx, () -> _trade.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addTrade(List<? extends Trade> trades) {
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
		public ValuationDocument.ValuationDocumentBuilder setTrade(List<? extends Trade> trades) {
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
		public ValuationDocument.ValuationDocumentBuilder addParty(Party _party) {
			if (_party != null) {
				this.party.add(_party.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addParty(Party _party, int idx) {
			getIndex(this.party, idx, () -> _party.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addParty(List<? extends Party> partys) {
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
		public ValuationDocument.ValuationDocumentBuilder setParty(List<? extends Party> partys) {
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
		public ValuationDocument.ValuationDocumentBuilder addAccount(Account _account) {
			if (_account != null) {
				this.account.add(_account.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addAccount(Account _account, int idx) {
			getIndex(this.account, idx, () -> _account.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addAccount(List<? extends Account> accounts) {
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
		public ValuationDocument.ValuationDocumentBuilder setAccount(List<? extends Account> accounts) {
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
		public ValuationDocument.ValuationDocumentBuilder addPortfolio(Portfolio _portfolio) {
			if (_portfolio != null) {
				this.portfolio.add(_portfolio.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addPortfolio(Portfolio _portfolio, int idx) {
			getIndex(this.portfolio, idx, () -> _portfolio.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addPortfolio(List<? extends Portfolio> portfolios) {
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
		public ValuationDocument.ValuationDocumentBuilder setPortfolio(List<? extends Portfolio> portfolios) {
			if (portfolios == null) {
				this.portfolio = new ArrayList<>();
			} else {
				this.portfolio = portfolios.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("market")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("market")
		@Override
		public ValuationDocument.ValuationDocumentBuilder addMarket(Market _market) {
			if (_market != null) {
				this.market.add(_market.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addMarket(Market _market, int idx) {
			getIndex(this.market, idx, () -> _market.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addMarket(List<? extends Market> markets) {
			if (markets != null) {
				for (final Market toAdd : markets) {
					this.market.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("market")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("market")
		@Override
		public ValuationDocument.ValuationDocumentBuilder setMarket(List<? extends Market> markets) {
			if (markets == null) {
				this.market = new ArrayList<>();
			} else {
				this.market = markets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("valuationSet")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("valuationSet")
		@Override
		public ValuationDocument.ValuationDocumentBuilder addValuationSet(ValuationSet _valuationSet) {
			if (_valuationSet != null) {
				this.valuationSet.add(_valuationSet.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addValuationSet(ValuationSet _valuationSet, int idx) {
			getIndex(this.valuationSet, idx, () -> _valuationSet.toBuilder());
			return this;
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder addValuationSet(List<? extends ValuationSet> valuationSets) {
			if (valuationSets != null) {
				for (final ValuationSet toAdd : valuationSets) {
					this.valuationSet.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("valuationSet")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("valuationSet")
		@Override
		public ValuationDocument.ValuationDocumentBuilder setValuationSet(List<? extends ValuationSet> valuationSets) {
			if (valuationSets == null) {
				this.valuationSet = new ArrayList<>();
			} else {
				this.valuationSet = valuationSets.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ValuationDocument build() {
			return new ValuationDocument.ValuationDocumentImpl(this);
		}
		
		@Override
		public ValuationDocument.ValuationDocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDocument.ValuationDocumentBuilder prune() {
			super.prune();
			market = market.stream().filter(b->b!=null).<Market.MarketBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			valuationSet = valuationSet.stream().filter(b->b!=null).<ValuationSet.ValuationSetBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getMarket()!=null && getMarket().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getValuationSet()!=null && getValuationSet().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationDocument.ValuationDocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ValuationDocument.ValuationDocumentBuilder o = (ValuationDocument.ValuationDocumentBuilder) other;
			
			merger.mergeRosetta(getMarket(), o.getMarket(), this::getOrCreateMarket);
			merger.mergeRosetta(getValuationSet(), o.getValuationSet(), this::getOrCreateValuationSet);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationDocument _that = getType().cast(o);
		
			if (!ListEquals.listEquals(market, _that.getMarket())) return false;
			if (!ListEquals.listEquals(valuationSet, _that.getValuationSet())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (market != null ? market.hashCode() : 0);
			_result = 31 * _result + (valuationSet != null ? valuationSet.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationDocumentBuilder {" +
				"market=" + this.market + ", " +
				"valuationSet=" + this.valuationSet +
			'}' + " " + super.toString();
		}
	}
}
