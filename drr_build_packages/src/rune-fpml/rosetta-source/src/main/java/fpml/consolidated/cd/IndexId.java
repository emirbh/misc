package fpml.consolidated.cd;

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
import fpml.consolidated.cd.meta.IndexIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
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
@RosettaDataType(value="IndexId", builder=IndexId.IndexIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="IndexId", model="fpml", builder=IndexId.IndexIdBuilderImpl.class, version="2.1.1")
public interface IndexId extends RosettaModelObject {

	IndexIdMeta metaData = new IndexIdMeta();

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
	String getValue();
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
	String getIndexIdScheme();

	/*********************** Build Methods  ***********************/
	IndexId build();
	
	IndexId.IndexIdBuilder toBuilder();
	
	static IndexId.IndexIdBuilder builder() {
		return new IndexId.IndexIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends IndexId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends IndexId> getType() {
		return IndexId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("indexIdScheme"), String.class, getIndexIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface IndexIdBuilder extends IndexId, RosettaModelObjectBuilder {
		IndexId.IndexIdBuilder setValue(String value);
		IndexId.IndexIdBuilder setIndexIdScheme(String indexIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("indexIdScheme"), String.class, getIndexIdScheme(), this);
		}
		

		IndexId.IndexIdBuilder prune();
	}

	/*********************** Immutable Implementation of IndexId  ***********************/
	class IndexIdImpl implements IndexId {
		private final String value;
		private final String indexIdScheme;
		
		protected IndexIdImpl(IndexId.IndexIdBuilder builder) {
			this.value = builder.getValue();
			this.indexIdScheme = builder.getIndexIdScheme();
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
		@RosettaAttribute("indexIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexIdScheme")
		public String getIndexIdScheme() {
			return indexIdScheme;
		}
		
		@Override
		public IndexId build() {
			return this;
		}
		
		@Override
		public IndexId.IndexIdBuilder toBuilder() {
			IndexId.IndexIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(IndexId.IndexIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getIndexIdScheme()).ifPresent(builder::setIndexIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(indexIdScheme, _that.getIndexIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (indexIdScheme != null ? indexIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexId {" +
				"value=" + this.value + ", " +
				"indexIdScheme=" + this.indexIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of IndexId  ***********************/
	class IndexIdBuilderImpl implements IndexId.IndexIdBuilder {
	
		protected String value;
		protected String indexIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("indexIdScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("indexIdScheme")
		public String getIndexIdScheme() {
			return indexIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public IndexId.IndexIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("indexIdScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("indexIdScheme")
		@Override
		public IndexId.IndexIdBuilder setIndexIdScheme(String _indexIdScheme) {
			this.indexIdScheme = _indexIdScheme == null ? null : _indexIdScheme;
			return this;
		}
		
		@Override
		public IndexId build() {
			return new IndexId.IndexIdImpl(this);
		}
		
		@Override
		public IndexId.IndexIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexId.IndexIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getIndexIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public IndexId.IndexIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			IndexId.IndexIdBuilder o = (IndexId.IndexIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getIndexIdScheme(), o.getIndexIdScheme(), this::setIndexIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			IndexId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(indexIdScheme, _that.getIndexIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (indexIdScheme != null ? indexIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "IndexIdBuilder {" +
				"value=" + this.value + ", " +
				"indexIdScheme=" + this.indexIdScheme +
			'}';
		}
	}
}
