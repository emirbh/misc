package fpml.consolidated.doc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.consolidated.doc.meta.QueryParameterMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type representing criteria for defining a query portfolio. The criteria are made up of a QueryParameterId, QueryParameterValue and QueryParameterOperator.
 *
 */
@RosettaDataType(value="QueryParameter", builder=QueryParameter.QueryParameterBuilderImpl.class, version="2.1.1")
@RuneDataType(value="QueryParameter", model="fpml", builder=QueryParameter.QueryParameterBuilderImpl.class, version="2.1.1")
public interface QueryParameter extends RosettaModelObject {

	QueryParameterMeta metaData = new QueryParameterMeta();

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
	QueryParameterId getQueryParameterId();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getQueryParameterValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	QueryParameterOperator getQueryParameterOperator();

	/*********************** Build Methods  ***********************/
	QueryParameter build();
	
	QueryParameter.QueryParameterBuilder toBuilder();
	
	static QueryParameter.QueryParameterBuilder builder() {
		return new QueryParameter.QueryParameterBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QueryParameter> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QueryParameter> getType() {
		return QueryParameter.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("queryParameterId"), processor, QueryParameterId.class, getQueryParameterId());
		processor.processBasic(path.newSubPath("queryParameterValue"), String.class, getQueryParameterValue(), this);
		processRosetta(path.newSubPath("queryParameterOperator"), processor, QueryParameterOperator.class, getQueryParameterOperator());
	}
	

	/*********************** Builder Interface  ***********************/
	interface QueryParameterBuilder extends QueryParameter, RosettaModelObjectBuilder {
		QueryParameterId.QueryParameterIdBuilder getOrCreateQueryParameterId();
		@Override
		QueryParameterId.QueryParameterIdBuilder getQueryParameterId();
		QueryParameterOperator.QueryParameterOperatorBuilder getOrCreateQueryParameterOperator();
		@Override
		QueryParameterOperator.QueryParameterOperatorBuilder getQueryParameterOperator();
		QueryParameter.QueryParameterBuilder setQueryParameterId(QueryParameterId queryParameterId);
		QueryParameter.QueryParameterBuilder setQueryParameterValue(String queryParameterValue);
		QueryParameter.QueryParameterBuilder setQueryParameterOperator(QueryParameterOperator queryParameterOperator);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("queryParameterId"), processor, QueryParameterId.QueryParameterIdBuilder.class, getQueryParameterId());
			processor.processBasic(path.newSubPath("queryParameterValue"), String.class, getQueryParameterValue(), this);
			processRosetta(path.newSubPath("queryParameterOperator"), processor, QueryParameterOperator.QueryParameterOperatorBuilder.class, getQueryParameterOperator());
		}
		

		QueryParameter.QueryParameterBuilder prune();
	}

	/*********************** Immutable Implementation of QueryParameter  ***********************/
	class QueryParameterImpl implements QueryParameter {
		private final QueryParameterId queryParameterId;
		private final String queryParameterValue;
		private final QueryParameterOperator queryParameterOperator;
		
		protected QueryParameterImpl(QueryParameter.QueryParameterBuilder builder) {
			this.queryParameterId = ofNullable(builder.getQueryParameterId()).map(f->f.build()).orElse(null);
			this.queryParameterValue = builder.getQueryParameterValue();
			this.queryParameterOperator = ofNullable(builder.getQueryParameterOperator()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("queryParameterId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryParameterId")
		public QueryParameterId getQueryParameterId() {
			return queryParameterId;
		}
		
		@Override
		@RosettaAttribute("queryParameterValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryParameterValue")
		public String getQueryParameterValue() {
			return queryParameterValue;
		}
		
		@Override
		@RosettaAttribute("queryParameterOperator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryParameterOperator")
		public QueryParameterOperator getQueryParameterOperator() {
			return queryParameterOperator;
		}
		
		@Override
		public QueryParameter build() {
			return this;
		}
		
		@Override
		public QueryParameter.QueryParameterBuilder toBuilder() {
			QueryParameter.QueryParameterBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QueryParameter.QueryParameterBuilder builder) {
			ofNullable(getQueryParameterId()).ifPresent(builder::setQueryParameterId);
			ofNullable(getQueryParameterValue()).ifPresent(builder::setQueryParameterValue);
			ofNullable(getQueryParameterOperator()).ifPresent(builder::setQueryParameterOperator);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QueryParameter _that = getType().cast(o);
		
			if (!Objects.equals(queryParameterId, _that.getQueryParameterId())) return false;
			if (!Objects.equals(queryParameterValue, _that.getQueryParameterValue())) return false;
			if (!Objects.equals(queryParameterOperator, _that.getQueryParameterOperator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (queryParameterId != null ? queryParameterId.hashCode() : 0);
			_result = 31 * _result + (queryParameterValue != null ? queryParameterValue.hashCode() : 0);
			_result = 31 * _result + (queryParameterOperator != null ? queryParameterOperator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QueryParameter {" +
				"queryParameterId=" + this.queryParameterId + ", " +
				"queryParameterValue=" + this.queryParameterValue + ", " +
				"queryParameterOperator=" + this.queryParameterOperator +
			'}';
		}
	}

	/*********************** Builder Implementation of QueryParameter  ***********************/
	class QueryParameterBuilderImpl implements QueryParameter.QueryParameterBuilder {
	
		protected QueryParameterId.QueryParameterIdBuilder queryParameterId;
		protected String queryParameterValue;
		protected QueryParameterOperator.QueryParameterOperatorBuilder queryParameterOperator;
		
		@Override
		@RosettaAttribute("queryParameterId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryParameterId")
		public QueryParameterId.QueryParameterIdBuilder getQueryParameterId() {
			return queryParameterId;
		}
		
		@Override
		public QueryParameterId.QueryParameterIdBuilder getOrCreateQueryParameterId() {
			QueryParameterId.QueryParameterIdBuilder result;
			if (queryParameterId!=null) {
				result = queryParameterId;
			}
			else {
				result = queryParameterId = QueryParameterId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("queryParameterValue")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryParameterValue")
		public String getQueryParameterValue() {
			return queryParameterValue;
		}
		
		@Override
		@RosettaAttribute("queryParameterOperator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryParameterOperator")
		public QueryParameterOperator.QueryParameterOperatorBuilder getQueryParameterOperator() {
			return queryParameterOperator;
		}
		
		@Override
		public QueryParameterOperator.QueryParameterOperatorBuilder getOrCreateQueryParameterOperator() {
			QueryParameterOperator.QueryParameterOperatorBuilder result;
			if (queryParameterOperator!=null) {
				result = queryParameterOperator;
			}
			else {
				result = queryParameterOperator = QueryParameterOperator.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("queryParameterId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("queryParameterId")
		@Override
		public QueryParameter.QueryParameterBuilder setQueryParameterId(QueryParameterId _queryParameterId) {
			this.queryParameterId = _queryParameterId == null ? null : _queryParameterId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("queryParameterValue")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("queryParameterValue")
		@Override
		public QueryParameter.QueryParameterBuilder setQueryParameterValue(String _queryParameterValue) {
			this.queryParameterValue = _queryParameterValue == null ? null : _queryParameterValue;
			return this;
		}
		
		@RosettaAttribute("queryParameterOperator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("queryParameterOperator")
		@Override
		public QueryParameter.QueryParameterBuilder setQueryParameterOperator(QueryParameterOperator _queryParameterOperator) {
			this.queryParameterOperator = _queryParameterOperator == null ? null : _queryParameterOperator.toBuilder();
			return this;
		}
		
		@Override
		public QueryParameter build() {
			return new QueryParameter.QueryParameterImpl(this);
		}
		
		@Override
		public QueryParameter.QueryParameterBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QueryParameter.QueryParameterBuilder prune() {
			if (queryParameterId!=null && !queryParameterId.prune().hasData()) queryParameterId = null;
			if (queryParameterOperator!=null && !queryParameterOperator.prune().hasData()) queryParameterOperator = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getQueryParameterId()!=null && getQueryParameterId().hasData()) return true;
			if (getQueryParameterValue()!=null) return true;
			if (getQueryParameterOperator()!=null && getQueryParameterOperator().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QueryParameter.QueryParameterBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QueryParameter.QueryParameterBuilder o = (QueryParameter.QueryParameterBuilder) other;
			
			merger.mergeRosetta(getQueryParameterId(), o.getQueryParameterId(), this::setQueryParameterId);
			merger.mergeRosetta(getQueryParameterOperator(), o.getQueryParameterOperator(), this::setQueryParameterOperator);
			
			merger.mergeBasic(getQueryParameterValue(), o.getQueryParameterValue(), this::setQueryParameterValue);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QueryParameter _that = getType().cast(o);
		
			if (!Objects.equals(queryParameterId, _that.getQueryParameterId())) return false;
			if (!Objects.equals(queryParameterValue, _that.getQueryParameterValue())) return false;
			if (!Objects.equals(queryParameterOperator, _that.getQueryParameterOperator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (queryParameterId != null ? queryParameterId.hashCode() : 0);
			_result = 31 * _result + (queryParameterValue != null ? queryParameterValue.hashCode() : 0);
			_result = 31 * _result + (queryParameterOperator != null ? queryParameterOperator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QueryParameterBuilder {" +
				"queryParameterId=" + this.queryParameterId + ", " +
				"queryParameterValue=" + this.queryParameterValue + ", " +
				"queryParameterOperator=" + this.queryParameterOperator +
			'}';
		}
	}
}
