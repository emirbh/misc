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
import fpml.consolidated.doc.meta.QueryParameterIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type representing an identifier for a parameter describing a query portfolio. An identifier can be anything from a product name like swap to a termination date.
 *
 */
@RosettaDataType(value="QueryParameterId", builder=QueryParameterId.QueryParameterIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="QueryParameterId", model="fpml", builder=QueryParameterId.QueryParameterIdBuilderImpl.class, version="2.1.1")
public interface QueryParameterId extends RosettaModelObject {

	QueryParameterIdMeta metaData = new QueryParameterIdMeta();

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
	String getQueryParameterIdScheme();
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
	QueryParameterId build();
	
	QueryParameterId.QueryParameterIdBuilder toBuilder();
	
	static QueryParameterId.QueryParameterIdBuilder builder() {
		return new QueryParameterId.QueryParameterIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends QueryParameterId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends QueryParameterId> getType() {
		return QueryParameterId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("queryParameterIdScheme"), String.class, getQueryParameterIdScheme(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface QueryParameterIdBuilder extends QueryParameterId, RosettaModelObjectBuilder {
		QueryParameterId.QueryParameterIdBuilder setValue(String value);
		QueryParameterId.QueryParameterIdBuilder setQueryParameterIdScheme(String queryParameterIdScheme);
		QueryParameterId.QueryParameterIdBuilder setId(String id);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("queryParameterIdScheme"), String.class, getQueryParameterIdScheme(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		}
		

		QueryParameterId.QueryParameterIdBuilder prune();
	}

	/*********************** Immutable Implementation of QueryParameterId  ***********************/
	class QueryParameterIdImpl implements QueryParameterId {
		private final String value;
		private final String queryParameterIdScheme;
		private final String id;
		
		protected QueryParameterIdImpl(QueryParameterId.QueryParameterIdBuilder builder) {
			this.value = builder.getValue();
			this.queryParameterIdScheme = builder.getQueryParameterIdScheme();
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
		@RosettaAttribute("queryParameterIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("queryParameterIdScheme")
		public String getQueryParameterIdScheme() {
			return queryParameterIdScheme;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		public QueryParameterId build() {
			return this;
		}
		
		@Override
		public QueryParameterId.QueryParameterIdBuilder toBuilder() {
			QueryParameterId.QueryParameterIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(QueryParameterId.QueryParameterIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getQueryParameterIdScheme()).ifPresent(builder::setQueryParameterIdScheme);
			ofNullable(getId()).ifPresent(builder::setId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QueryParameterId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(queryParameterIdScheme, _that.getQueryParameterIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (queryParameterIdScheme != null ? queryParameterIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QueryParameterId {" +
				"value=" + this.value + ", " +
				"queryParameterIdScheme=" + this.queryParameterIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}

	/*********************** Builder Implementation of QueryParameterId  ***********************/
	class QueryParameterIdBuilderImpl implements QueryParameterId.QueryParameterIdBuilder {
	
		protected String value;
		protected String queryParameterIdScheme;
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
		@RosettaAttribute("queryParameterIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("queryParameterIdScheme")
		public String getQueryParameterIdScheme() {
			return queryParameterIdScheme;
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
		public QueryParameterId.QueryParameterIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("queryParameterIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("queryParameterIdScheme")
		@Override
		public QueryParameterId.QueryParameterIdBuilder setQueryParameterIdScheme(String _queryParameterIdScheme) {
			this.queryParameterIdScheme = _queryParameterIdScheme == null ? null : _queryParameterIdScheme;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public QueryParameterId.QueryParameterIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@Override
		public QueryParameterId build() {
			return new QueryParameterId.QueryParameterIdImpl(this);
		}
		
		@Override
		public QueryParameterId.QueryParameterIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QueryParameterId.QueryParameterIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getQueryParameterIdScheme()!=null) return true;
			if (getId()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public QueryParameterId.QueryParameterIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			QueryParameterId.QueryParameterIdBuilder o = (QueryParameterId.QueryParameterIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getQueryParameterIdScheme(), o.getQueryParameterIdScheme(), this::setQueryParameterIdScheme);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			QueryParameterId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(queryParameterIdScheme, _that.getQueryParameterIdScheme())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (queryParameterIdScheme != null ? queryParameterIdScheme.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "QueryParameterIdBuilder {" +
				"value=" + this.value + ", " +
				"queryParameterIdScheme=" + this.queryParameterIdScheme + ", " +
				"id=" + this.id +
			'}';
		}
	}
}
