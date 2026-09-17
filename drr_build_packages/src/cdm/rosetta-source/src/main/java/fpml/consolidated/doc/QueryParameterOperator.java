package fpml.consolidated.doc;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
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
import fpml.consolidated.doc.meta.QueryParameterOperatorMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type representing an operator describing the relationship of a value to its corresponding identifier for a parameter describing a query portfolio. Possible relationships include equals, not equals, less than, greater than. Possible operators are listed in the queryParameterOperatorScheme.
 *
 */
@RosettaDataType(value="QueryParameterOperator", builder=QueryParameterOperator.QueryParameterOperatorBuilderImpl.class, version="2.1.1")
@RuneDataType(value="QueryParameterOperator", model="fpml", builder=QueryParameterOperator.QueryParameterOperatorBuilderImpl.class, version="2.1.1")
public interface QueryParameterOperator extends RosettaModelObject {

	QueryParameterOperatorMeta metaData = new QueryParameterOperatorMeta();

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
	String getValue();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getQueryParameterOperatorScheme();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	String getId();

	/*********************** Build Methods  ***********************/
	QueryParameterOperator build();
	
	QueryParameterOperator.QueryParameterOperatorBuilder toBuilder();
	
	static QueryParameterOperator.QueryParameterOperatorBuilder builder() {
		return new QueryParameterOperator.QueryParameterOperatorBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QueryParameterOperator> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QueryParameterOperator> getType() {
		return QueryParameterOperator.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("queryParameterOperatorScheme"), String.class, getQueryParameterOperatorScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface QueryParameterOperatorBuilder extends QueryParameterOperator, RosettaModelObjectBuilder {
		QueryParameterOperator.QueryParameterOperatorBuilder setValue(String value);
		QueryParameterOperator.QueryParameterOperatorBuilder setQueryParameterOperatorScheme(String queryParameterOperatorScheme);
		QueryParameterOperator.QueryParameterOperatorBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("queryParameterOperatorScheme"), String.class, getQueryParameterOperatorScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		QueryParameterOperator.QueryParameterOperatorBuilder prune();
	}

	/*********************** Immutable Implementation of QueryParameterOperator  ***********************/
	class QueryParameterOperatorImpl implements QueryParameterOperator {
		private final String value;
		private final String queryParameterOperatorScheme;
		private final String id;
		
		protected QueryParameterOperatorImpl(QueryParameterOperator.QueryParameterOperatorBuilder builder) {
			this.value = builder.getValue();
			this.queryParameterOperatorScheme = builder.getQueryParameterOperatorScheme();
			this.id = builder.getId();
		}
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("queryParameterOperatorScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryParameterOperatorScheme")
		public String getQueryParameterOperatorScheme() {
			return queryParameterOperatorScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public QueryParameterOperator build() {
			return this;
		}
		
		@Override
		public QueryParameterOperator.QueryParameterOperatorBuilder toBuilder() {
			QueryParameterOperator.QueryParameterOperatorBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QueryParameterOperator.QueryParameterOperatorBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getQueryParameterOperatorScheme()).ifPresent(builder::setQueryParameterOperatorScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QueryParameterOperator _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(queryParameterOperatorScheme, _that.getQueryParameterOperatorScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (queryParameterOperatorScheme != null ? queryParameterOperatorScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QueryParameterOperator {" +
				"value=" + this.value + ", " +
				"queryParameterOperatorScheme=" + this.queryParameterOperatorScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of QueryParameterOperator  ***********************/
	class QueryParameterOperatorBuilderImpl implements QueryParameterOperator.QueryParameterOperatorBuilder {
	
		protected String value;
		protected String queryParameterOperatorScheme;
		protected String id;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("queryParameterOperatorScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("queryParameterOperatorScheme")
		public String getQueryParameterOperatorScheme() {
			return queryParameterOperatorScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public QueryParameterOperator.QueryParameterOperatorBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("queryParameterOperatorScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("queryParameterOperatorScheme")
		@Override
		public QueryParameterOperator.QueryParameterOperatorBuilder setQueryParameterOperatorScheme(String _queryParameterOperatorScheme) {
			this.queryParameterOperatorScheme = _queryParameterOperatorScheme == null ? null : _queryParameterOperatorScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public QueryParameterOperator.QueryParameterOperatorBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public QueryParameterOperator build() {
			return new QueryParameterOperator.QueryParameterOperatorImpl(this);
		}
		
		@Override
		public QueryParameterOperator.QueryParameterOperatorBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QueryParameterOperator.QueryParameterOperatorBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getQueryParameterOperatorScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QueryParameterOperator.QueryParameterOperatorBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QueryParameterOperator.QueryParameterOperatorBuilder o = (QueryParameterOperator.QueryParameterOperatorBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getQueryParameterOperatorScheme(), o.getQueryParameterOperatorScheme(), this::setQueryParameterOperatorScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QueryParameterOperator _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(queryParameterOperatorScheme, _that.getQueryParameterOperatorScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (queryParameterOperatorScheme != null ? queryParameterOperatorScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QueryParameterOperatorBuilder {" +
				"value=" + this.value + ", " +
				"queryParameterOperatorScheme=" + this.queryParameterOperatorScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
