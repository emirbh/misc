package fpml.consolidated.doc;

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
import fpml.consolidated.doc.meta.PortfolioMeta;
import fpml.consolidated.shared.TradeId;
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
 * Provision A type representing an arbitary grouping of trade references.
 *
 */
@RosettaDataType(value="Portfolio", builder=Portfolio.PortfolioBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Portfolio", model="fpml", builder=Portfolio.PortfolioBuilderImpl.class, version="2.1.1")
public interface Portfolio extends RosettaModelObject {

	PortfolioMeta metaData = new PortfolioMeta();

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
	String getId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The name of the portfolio together with the party that gave the name.
	 *
	 */
	PartyPortfolioName getPartyPortfolioName();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends TradeId> getTradeId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends PartyTradeIdentifier> getPartyTradeIdentifier();
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
	Portfolio build();
	
	Portfolio.PortfolioBuilder toBuilder();
	
	static Portfolio.PortfolioBuilder builder() {
		return new Portfolio.PortfolioBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Portfolio> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Portfolio> getType() {
		return Portfolio.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyPortfolioName"), processor, PartyPortfolioName.class, getPartyPortfolioName());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("portfolio"), processor, Portfolio.class, getPortfolio());
	}
	

	/*********************** Builder Interface  ***********************/
	interface PortfolioBuilder extends Portfolio, RosettaModelObjectBuilder {
		PartyPortfolioName.PartyPortfolioNameBuilder getOrCreatePartyPortfolioName();
		@Override
		PartyPortfolioName.PartyPortfolioNameBuilder getPartyPortfolioName();
		TradeId.TradeIdBuilder getOrCreateTradeId(int index);
		@Override
		List<? extends TradeId.TradeIdBuilder> getTradeId();
		PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index);
		@Override
		List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier();
		Portfolio.PortfolioBuilder getOrCreatePortfolio(int index);
		@Override
		List<? extends Portfolio.PortfolioBuilder> getPortfolio();
		Portfolio.PortfolioBuilder setId(String id);
		Portfolio.PortfolioBuilder setPartyPortfolioName(PartyPortfolioName partyPortfolioName);
		Portfolio.PortfolioBuilder addTradeId(TradeId tradeId);
		Portfolio.PortfolioBuilder addTradeId(TradeId tradeId, int idx);
		Portfolio.PortfolioBuilder addTradeId(List<? extends TradeId> tradeId);
		Portfolio.PortfolioBuilder setTradeId(List<? extends TradeId> tradeId);
		Portfolio.PortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		Portfolio.PortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int idx);
		Portfolio.PortfolioBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		Portfolio.PortfolioBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		Portfolio.PortfolioBuilder addPortfolio(Portfolio portfolio);
		Portfolio.PortfolioBuilder addPortfolio(Portfolio portfolio, int idx);
		Portfolio.PortfolioBuilder addPortfolio(List<? extends Portfolio> portfolio);
		Portfolio.PortfolioBuilder setPortfolio(List<? extends Portfolio> portfolio);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyPortfolioName"), processor, PartyPortfolioName.PartyPortfolioNameBuilder.class, getPartyPortfolioName());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("portfolio"), processor, Portfolio.PortfolioBuilder.class, getPortfolio());
		}
		

		Portfolio.PortfolioBuilder prune();
	}

	/*********************** Immutable Implementation of Portfolio  ***********************/
	class PortfolioImpl implements Portfolio {
		private final String id;
		private final PartyPortfolioName partyPortfolioName;
		private final List<? extends TradeId> tradeId;
		private final List<? extends PartyTradeIdentifier> partyTradeIdentifier;
		private final List<? extends Portfolio> portfolio;
		
		protected PortfolioImpl(Portfolio.PortfolioBuilder builder) {
			this.id = builder.getId();
			this.partyPortfolioName = ofNullable(builder.getPartyPortfolioName()).map(f->f.build()).orElse(null);
			this.tradeId = ofNullable(builder.getTradeId()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.partyTradeIdentifier = ofNullable(builder.getPartyTradeIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.portfolio = ofNullable(builder.getPortfolio()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyPortfolioName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyPortfolioName")
		public PartyPortfolioName getPartyPortfolioName() {
			return partyPortfolioName;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeId")
		public List<? extends TradeId> getTradeId() {
			return tradeId;
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
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
		public Portfolio build() {
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder toBuilder() {
			Portfolio.PortfolioBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Portfolio.PortfolioBuilder builder) {
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getPartyPortfolioName()).ifPresent(builder::setPartyPortfolioName);
			ofNullable(getTradeId()).ifPresent(builder::setTradeId);
			ofNullable(getPartyTradeIdentifier()).ifPresent(builder::setPartyTradeIdentifier);
			ofNullable(getPortfolio()).ifPresent(builder::setPortfolio);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Portfolio _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyPortfolioName, _that.getPartyPortfolioName())) return false;
			if (!ListEquals.listEquals(tradeId, _that.getTradeId())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(portfolio, _that.getPortfolio())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyPortfolioName != null ? partyPortfolioName.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Portfolio {" +
				"id=" + this.id + ", " +
				"partyPortfolioName=" + this.partyPortfolioName + ", " +
				"tradeId=" + this.tradeId + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"portfolio=" + this.portfolio +
			'}';
		}
	}

	/*********************** Builder Implementation of Portfolio  ***********************/
	class PortfolioBuilderImpl implements Portfolio.PortfolioBuilder {
	
		protected String id;
		protected PartyPortfolioName.PartyPortfolioNameBuilder partyPortfolioName;
		protected List<TradeId.TradeIdBuilder> tradeId = new ArrayList<>();
		protected List<PartyTradeIdentifier.PartyTradeIdentifierBuilder> partyTradeIdentifier = new ArrayList<>();
		protected List<Portfolio.PortfolioBuilder> portfolio = new ArrayList<>();
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("partyPortfolioName")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("partyPortfolioName")
		public PartyPortfolioName.PartyPortfolioNameBuilder getPartyPortfolioName() {
			return partyPortfolioName;
		}
		
		@Override
		public PartyPortfolioName.PartyPortfolioNameBuilder getOrCreatePartyPortfolioName() {
			PartyPortfolioName.PartyPortfolioNameBuilder result;
			if (partyPortfolioName!=null) {
				result = partyPortfolioName;
			}
			else {
				result = partyPortfolioName = PartyPortfolioName.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("tradeId")
		public List<? extends TradeId.TradeIdBuilder> getTradeId() {
			return tradeId;
		}
		
		@Override
		public TradeId.TradeIdBuilder getOrCreateTradeId(int index) {
			if (tradeId==null) {
				this.tradeId = new ArrayList<>();
			}
			return getIndex(tradeId, index, () -> {
						TradeId.TradeIdBuilder newTradeId = TradeId.builder();
						return newTradeId;
					});
		}
		
		@Override
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		public List<? extends PartyTradeIdentifier.PartyTradeIdentifierBuilder> getPartyTradeIdentifier() {
			return partyTradeIdentifier;
		}
		
		@Override
		public PartyTradeIdentifier.PartyTradeIdentifierBuilder getOrCreatePartyTradeIdentifier(int index) {
			if (partyTradeIdentifier==null) {
				this.partyTradeIdentifier = new ArrayList<>();
			}
			return getIndex(partyTradeIdentifier, index, () -> {
						PartyTradeIdentifier.PartyTradeIdentifierBuilder newPartyTradeIdentifier = PartyTradeIdentifier.builder();
						return newPartyTradeIdentifier;
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
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public Portfolio.PortfolioBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyPortfolioName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyPortfolioName")
		@Override
		public Portfolio.PortfolioBuilder setPartyPortfolioName(PartyPortfolioName _partyPortfolioName) {
			this.partyPortfolioName = _partyPortfolioName == null ? null : _partyPortfolioName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeId")
		@Override
		public Portfolio.PortfolioBuilder addTradeId(TradeId _tradeId) {
			if (_tradeId != null) {
				this.tradeId.add(_tradeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addTradeId(TradeId _tradeId, int idx) {
			getIndex(this.tradeId, idx, () -> _tradeId.toBuilder());
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addTradeId(List<? extends TradeId> tradeIds) {
			if (tradeIds != null) {
				for (final TradeId toAdd : tradeIds) {
					this.tradeId.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("tradeId")
		@Override
		public Portfolio.PortfolioBuilder setTradeId(List<? extends TradeId> tradeIds) {
			if (tradeIds == null) {
				this.tradeId = new ArrayList<>();
			} else {
				this.tradeId = tradeIds.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public Portfolio.PortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier) {
			if (_partyTradeIdentifier != null) {
				this.partyTradeIdentifier.add(_partyTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier, int idx) {
			getIndex(this.partyTradeIdentifier, idx, () -> _partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers != null) {
				for (final PartyTradeIdentifier toAdd : partyTradeIdentifiers) {
					this.partyTradeIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyTradeIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyTradeIdentifier")
		@Override
		public Portfolio.PortfolioBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
			if (partyTradeIdentifiers == null) {
				this.partyTradeIdentifier = new ArrayList<>();
			} else {
				this.partyTradeIdentifier = partyTradeIdentifiers.stream()
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
		public Portfolio.PortfolioBuilder addPortfolio(Portfolio _portfolio) {
			if (_portfolio != null) {
				this.portfolio.add(_portfolio.toBuilder());
			}
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addPortfolio(Portfolio _portfolio, int idx) {
			getIndex(this.portfolio, idx, () -> _portfolio.toBuilder());
			return this;
		}
		
		@Override
		public Portfolio.PortfolioBuilder addPortfolio(List<? extends Portfolio> portfolios) {
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
		public Portfolio.PortfolioBuilder setPortfolio(List<? extends Portfolio> portfolios) {
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
		public Portfolio build() {
			return new Portfolio.PortfolioImpl(this);
		}
		
		@Override
		public Portfolio.PortfolioBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Portfolio.PortfolioBuilder prune() {
			if (partyPortfolioName!=null && !partyPortfolioName.prune().hasData()) partyPortfolioName = null;
			tradeId = tradeId.stream().filter(b->b!=null).<TradeId.TradeIdBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			partyTradeIdentifier = partyTradeIdentifier.stream().filter(b->b!=null).<PartyTradeIdentifier.PartyTradeIdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			portfolio = portfolio.stream().filter(b->b!=null).<Portfolio.PortfolioBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getId()!=null) return true;
			if (getPartyPortfolioName()!=null && getPartyPortfolioName().hasData()) return true;
			if (getTradeId()!=null && getTradeId().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPartyTradeIdentifier()!=null && getPartyTradeIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getPortfolio()!=null && getPortfolio().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Portfolio.PortfolioBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Portfolio.PortfolioBuilder o = (Portfolio.PortfolioBuilder) other;
			
			merger.mergeRosetta(getPartyPortfolioName(), o.getPartyPortfolioName(), this::setPartyPortfolioName);
			merger.mergeRosetta(getTradeId(), o.getTradeId(), this::getOrCreateTradeId);
			merger.mergeRosetta(getPartyTradeIdentifier(), o.getPartyTradeIdentifier(), this::getOrCreatePartyTradeIdentifier);
			merger.mergeRosetta(getPortfolio(), o.getPortfolio(), this::getOrCreatePortfolio);
			
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Portfolio _that = getType().cast(o);
		
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(partyPortfolioName, _that.getPartyPortfolioName())) return false;
			if (!ListEquals.listEquals(tradeId, _that.getTradeId())) return false;
			if (!ListEquals.listEquals(partyTradeIdentifier, _that.getPartyTradeIdentifier())) return false;
			if (!ListEquals.listEquals(portfolio, _that.getPortfolio())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (partyPortfolioName != null ? partyPortfolioName.hashCode() : 0);
			_result = 31 * _result + (tradeId != null ? tradeId.hashCode() : 0);
			_result = 31 * _result + (partyTradeIdentifier != null ? partyTradeIdentifier.hashCode() : 0);
			_result = 31 * _result + (portfolio != null ? portfolio.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "PortfolioBuilder {" +
				"id=" + this.id + ", " +
				"partyPortfolioName=" + this.partyPortfolioName + ", " +
				"tradeId=" + this.tradeId + ", " +
				"partyTradeIdentifier=" + this.partyTradeIdentifier + ", " +
				"portfolio=" + this.portfolio +
			'}';
		}
	}
}
