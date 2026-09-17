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
import fpml.consolidated.doc.meta.LinkIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for link identifiers.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for link identifiers.
 *
 */
@RosettaDataType(value="LinkId", builder=LinkId.LinkIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LinkId", model="fpml", builder=LinkId.LinkIdBuilderImpl.class, version="2.1.1")
public interface LinkId extends RosettaModelObject {

	LinkIdMeta metaData = new LinkIdMeta();

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
	String getId();
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
	String getLinkIdScheme();

	/*********************** Build Methods  ***********************/
	LinkId build();
	
	LinkId.LinkIdBuilder toBuilder();
	
	static LinkId.LinkIdBuilder builder() {
		return new LinkId.LinkIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LinkId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LinkId> getType() {
		return LinkId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
		processor.processBasic(path.newSubPath("linkIdScheme"), String.class, getLinkIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LinkIdBuilder extends LinkId, RosettaModelObjectBuilder {
		LinkId.LinkIdBuilder setValue(String value);
		LinkId.LinkIdBuilder setId(String id);
		LinkId.LinkIdBuilder setLinkIdScheme(String linkIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("id"), String.class, getId(), this);
			processor.processBasic(path.newSubPath("linkIdScheme"), String.class, getLinkIdScheme(), this);
		}
		

		LinkId.LinkIdBuilder prune();
	}

	/*********************** Immutable Implementation of LinkId  ***********************/
	class LinkIdImpl implements LinkId {
		private final String value;
		private final String id;
		private final String linkIdScheme;
		
		protected LinkIdImpl(LinkId.LinkIdBuilder builder) {
			this.value = builder.getValue();
			this.id = builder.getId();
			this.linkIdScheme = builder.getLinkIdScheme();
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
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("linkIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("linkIdScheme")
		public String getLinkIdScheme() {
			return linkIdScheme;
		}
		
		@Override
		public LinkId build() {
			return this;
		}
		
		@Override
		public LinkId.LinkIdBuilder toBuilder() {
			LinkId.LinkIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LinkId.LinkIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getId()).ifPresent(builder::setId);
			ofNullable(getLinkIdScheme()).ifPresent(builder::setLinkIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LinkId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(linkIdScheme, _that.getLinkIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (linkIdScheme != null ? linkIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LinkId {" +
				"value=" + this.value + ", " +
				"id=" + this.id + ", " +
				"linkIdScheme=" + this.linkIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LinkId  ***********************/
	class LinkIdBuilderImpl implements LinkId.LinkIdBuilder {
	
		protected String value;
		protected String id;
		protected String linkIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("id")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("id")
		public String getId() {
			return id;
		}
		
		@Override
		@RosettaAttribute("linkIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("linkIdScheme")
		public String getLinkIdScheme() {
			return linkIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LinkId.LinkIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("id")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("id")
		@Override
		public LinkId.LinkIdBuilder setId(String _id) {
			this.id = _id == null ? null : _id;
			return this;
		}
		
		@RosettaAttribute("linkIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("linkIdScheme")
		@Override
		public LinkId.LinkIdBuilder setLinkIdScheme(String _linkIdScheme) {
			this.linkIdScheme = _linkIdScheme == null ? null : _linkIdScheme;
			return this;
		}
		
		@Override
		public LinkId build() {
			return new LinkId.LinkIdImpl(this);
		}
		
		@Override
		public LinkId.LinkIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LinkId.LinkIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getId()!=null) return true;
			if (getLinkIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LinkId.LinkIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LinkId.LinkIdBuilder o = (LinkId.LinkIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getId(), o.getId(), this::setId);
			merger.mergeBasic(getLinkIdScheme(), o.getLinkIdScheme(), this::setLinkIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LinkId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(id, _that.getId())) return false;
			if (!Objects.equals(linkIdScheme, _that.getLinkIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (id != null ? id.hashCode() : 0);
			_result = 31 * _result + (linkIdScheme != null ? linkIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LinkIdBuilder {" +
				"value=" + this.value + ", " +
				"id=" + this.id + ", " +
				"linkIdScheme=" + this.linkIdScheme +
			'}';
		}
	}
}
