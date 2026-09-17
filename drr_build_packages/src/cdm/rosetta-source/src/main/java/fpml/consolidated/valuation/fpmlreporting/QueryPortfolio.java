package fpml.consolidated.valuation.fpmlreporting;

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
import fpml.consolidated.doc.PartyPortfolioName;
import fpml.consolidated.doc.PartyTradeIdentifier;
import fpml.consolidated.doc.QueryParameter;
import fpml.consolidated.shared.TradeId;
import fpml.consolidated.valuation.fpmlreporting.meta.QueryPortfolioMeta;
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
 * Provision A type representing a portfolio obtained by querying the set of trades held in a repository. It contains trades matching the intersection of all criteria specified using one or more queryParameters or trades matching the union of two or more child queryPortfolios.
 *
 */
@RosettaDataType(value="QueryPortfolio", builder=QueryPortfolio.QueryPortfolioBuilderImpl.class, version="2.1.1")
@RuneDataType(value="QueryPortfolio", model="fpml", builder=QueryPortfolio.QueryPortfolioBuilderImpl.class, version="2.1.1")
public interface QueryPortfolio extends Portfolio {

	QueryPortfolioMeta metaData = new QueryPortfolioMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	List<? extends QueryParameter> getQueryParameter();

	/*********************** Build Methods  ***********************/
	QueryPortfolio build();
	
	QueryPortfolio.QueryPortfolioBuilder toBuilder();
	
	static QueryPortfolio.QueryPortfolioBuilder builder() {
		return new QueryPortfolio.QueryPortfolioBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QueryPortfolio> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QueryPortfolio> getType() {
		return QueryPortfolio.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processRosetta(path.newSubPath("partyPortfolioName"), processor, PartyPortfolioName.class, getPartyPortfolioName());
		processRosetta(path.newSubPath("tradeId"), processor, TradeId.class, getTradeId());
		processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.class, getPartyTradeIdentifier());
		processRosetta(path.newSubPath("portfolio"), processor, Portfolio.class, getPortfolio());
		processRosetta(path.newSubPath("queryParameter"), processor, QueryParameter.class, getQueryParameter());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QueryPortfolioBuilder extends QueryPortfolio, Portfolio.PortfolioBuilder {
		QueryParameter.QueryParameterBuilder getOrCreateQueryParameter(int index);
		@Override
		List<? extends QueryParameter.QueryParameterBuilder> getQueryParameter();
		@Override
		QueryPortfolio.QueryPortfolioBuilder setId(String id);
		@Override
		QueryPortfolio.QueryPortfolioBuilder setPartyPortfolioName(PartyPortfolioName partyPortfolioName);
		@Override
		QueryPortfolio.QueryPortfolioBuilder addTradeId(TradeId tradeId);
		@Override
		QueryPortfolio.QueryPortfolioBuilder addTradeId(TradeId tradeId, int idx);
		@Override
		QueryPortfolio.QueryPortfolioBuilder addTradeId(List<? extends TradeId> tradeId);
		@Override
		QueryPortfolio.QueryPortfolioBuilder setTradeId(List<? extends TradeId> tradeId);
		@Override
		QueryPortfolio.QueryPortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier);
		@Override
		QueryPortfolio.QueryPortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier partyTradeIdentifier, int idx);
		@Override
		QueryPortfolio.QueryPortfolioBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		@Override
		QueryPortfolio.QueryPortfolioBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifier);
		@Override
		QueryPortfolio.QueryPortfolioBuilder addPortfolio(Portfolio portfolio);
		@Override
		QueryPortfolio.QueryPortfolioBuilder addPortfolio(Portfolio portfolio, int idx);
		@Override
		QueryPortfolio.QueryPortfolioBuilder addPortfolio(List<? extends Portfolio> portfolio);
		@Override
		QueryPortfolio.QueryPortfolioBuilder setPortfolio(List<? extends Portfolio> portfolio);
		QueryPortfolio.QueryPortfolioBuilder addQueryParameter(QueryParameter queryParameter);
		QueryPortfolio.QueryPortfolioBuilder addQueryParameter(QueryParameter queryParameter, int idx);
		QueryPortfolio.QueryPortfolioBuilder addQueryParameter(List<? extends QueryParameter> queryParameter);
		QueryPortfolio.QueryPortfolioBuilder setQueryParameter(List<? extends QueryParameter> queryParameter);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processRosetta(path.newSubPath("partyPortfolioName"), processor, PartyPortfolioName.PartyPortfolioNameBuilder.class, getPartyPortfolioName());
			processRosetta(path.newSubPath("tradeId"), processor, TradeId.TradeIdBuilder.class, getTradeId());
			processRosetta(path.newSubPath("partyTradeIdentifier"), processor, PartyTradeIdentifier.PartyTradeIdentifierBuilder.class, getPartyTradeIdentifier());
			processRosetta(path.newSubPath("portfolio"), processor, Portfolio.PortfolioBuilder.class, getPortfolio());
			processRosetta(path.newSubPath("queryParameter"), processor, QueryParameter.QueryParameterBuilder.class, getQueryParameter());
		}
		

		QueryPortfolio.QueryPortfolioBuilder prune();
	}

	/*********************** Immutable Implementation of QueryPortfolio  ***********************/
	class QueryPortfolioImpl extends Portfolio.PortfolioImpl implements QueryPortfolio {
		private final List<? extends QueryParameter> queryParameter;
		
		protected QueryPortfolioImpl(QueryPortfolio.QueryPortfolioBuilder builder) {
			super(builder);
			this.queryParameter = ofNullable(builder.getQueryParameter()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("queryParameter")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("queryParameter")
		public List<? extends QueryParameter> getQueryParameter() {
			return queryParameter;
		}
		
		@Override
		public QueryPortfolio build() {
			return this;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder toBuilder() {
			QueryPortfolio.QueryPortfolioBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QueryPortfolio.QueryPortfolioBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getQueryParameter()).ifPresent(builder::setQueryParameter);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			QueryPortfolio _that = getType().cast(o);
		
			if (!ListEquals.listEquals(queryParameter, _that.getQueryParameter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (queryParameter != null ? queryParameter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QueryPortfolio {" +
				"queryParameter=" + this.queryParameter +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of QueryPortfolio  ***********************/
	class QueryPortfolioBuilderImpl extends Portfolio.PortfolioBuilderImpl implements QueryPortfolio.QueryPortfolioBuilder {
	
		protected List<QueryParameter.QueryParameterBuilder> queryParameter = new ArrayList<>();
		
		@Override
		@RosettaAttribute("queryParameter")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("queryParameter")
		public List<? extends QueryParameter.QueryParameterBuilder> getQueryParameter() {
			return queryParameter;
		}
		
		@Override
		public QueryParameter.QueryParameterBuilder getOrCreateQueryParameter(int index) {
			if (queryParameter==null) {
				this.queryParameter = new ArrayList<>();
			}
			return getIndex(queryParameter, index, () -> {
						QueryParameter.QueryParameterBuilder newQueryParameter = QueryParameter.builder();
						return newQueryParameter;
					});
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public QueryPortfolio.QueryPortfolioBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("partyPortfolioName")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("partyPortfolioName")
		@Override
		public QueryPortfolio.QueryPortfolioBuilder setPartyPortfolioName(PartyPortfolioName _partyPortfolioName) {
			this.partyPortfolioName = _partyPortfolioName == null ? null : _partyPortfolioName.toBuilder();
			return this;
		}
		
		@RosettaAttribute("tradeId")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("tradeId")
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addTradeId(TradeId _tradeId) {
			if (_tradeId != null) {
				this.tradeId.add(_tradeId.toBuilder());
			}
			return this;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addTradeId(TradeId _tradeId, int idx) {
			getIndex(this.tradeId, idx, () -> _tradeId.toBuilder());
			return this;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addTradeId(List<? extends TradeId> tradeIds) {
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
		public QueryPortfolio.QueryPortfolioBuilder setTradeId(List<? extends TradeId> tradeIds) {
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
		public QueryPortfolio.QueryPortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier) {
			if (_partyTradeIdentifier != null) {
				this.partyTradeIdentifier.add(_partyTradeIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addPartyTradeIdentifier(PartyTradeIdentifier _partyTradeIdentifier, int idx) {
			getIndex(this.partyTradeIdentifier, idx, () -> _partyTradeIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
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
		public QueryPortfolio.QueryPortfolioBuilder setPartyTradeIdentifier(List<? extends PartyTradeIdentifier> partyTradeIdentifiers) {
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
		public QueryPortfolio.QueryPortfolioBuilder addPortfolio(Portfolio _portfolio) {
			if (_portfolio != null) {
				this.portfolio.add(_portfolio.toBuilder());
			}
			return this;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addPortfolio(Portfolio _portfolio, int idx) {
			getIndex(this.portfolio, idx, () -> _portfolio.toBuilder());
			return this;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addPortfolio(List<? extends Portfolio> portfolios) {
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
		public QueryPortfolio.QueryPortfolioBuilder setPortfolio(List<? extends Portfolio> portfolios) {
			if (portfolios == null) {
				this.portfolio = new ArrayList<>();
			} else {
				this.portfolio = portfolios.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("queryParameter")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("queryParameter")
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addQueryParameter(QueryParameter _queryParameter) {
			if (_queryParameter != null) {
				this.queryParameter.add(_queryParameter.toBuilder());
			}
			return this;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addQueryParameter(QueryParameter _queryParameter, int idx) {
			getIndex(this.queryParameter, idx, () -> _queryParameter.toBuilder());
			return this;
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder addQueryParameter(List<? extends QueryParameter> queryParameters) {
			if (queryParameters != null) {
				for (final QueryParameter toAdd : queryParameters) {
					this.queryParameter.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("queryParameter")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("queryParameter")
		@Override
		public QueryPortfolio.QueryPortfolioBuilder setQueryParameter(List<? extends QueryParameter> queryParameters) {
			if (queryParameters == null) {
				this.queryParameter = new ArrayList<>();
			} else {
				this.queryParameter = queryParameters.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public QueryPortfolio build() {
			return new QueryPortfolio.QueryPortfolioImpl(this);
		}
		
		@Override
		public QueryPortfolio.QueryPortfolioBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QueryPortfolio.QueryPortfolioBuilder prune() {
			super.prune();
			queryParameter = queryParameter.stream().filter(b->b!=null).<QueryParameter.QueryParameterBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getQueryParameter()!=null && getQueryParameter().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QueryPortfolio.QueryPortfolioBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			QueryPortfolio.QueryPortfolioBuilder o = (QueryPortfolio.QueryPortfolioBuilder) other;
			
			merger.mergeRosetta(getQueryParameter(), o.getQueryParameter(), this::getOrCreateQueryParameter);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			QueryPortfolio _that = getType().cast(o);
		
			if (!ListEquals.listEquals(queryParameter, _that.getQueryParameter())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (queryParameter != null ? queryParameter.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QueryPortfolioBuilder {" +
				"queryParameter=" + this.queryParameter +
			'}' + " " + super.toString();
		}
	}
}
