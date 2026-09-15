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
import fpml.consolidated.doc.meta.LinkTypeMeta;
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
@RosettaDataType(value="LinkType", builder=LinkType.LinkTypeBuilderImpl.class, version="2.1.1")
@RuneDataType(value="LinkType", model="fpml", builder=LinkType.LinkTypeBuilderImpl.class, version="2.1.1")
public interface LinkType extends RosettaModelObject {

	LinkTypeMeta metaData = new LinkTypeMeta();

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
	String getLinkTypeScheme();

	/*********************** Build Methods  ***********************/
	LinkType build();
	
	LinkType.LinkTypeBuilder toBuilder();
	
	static LinkType.LinkTypeBuilder builder() {
		return new LinkType.LinkTypeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LinkType> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends LinkType> getType() {
		return LinkType.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("linkTypeScheme"), String.class, getLinkTypeScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LinkTypeBuilder extends LinkType, RosettaModelObjectBuilder {
		LinkType.LinkTypeBuilder setValue(String value);
		LinkType.LinkTypeBuilder setLinkTypeScheme(String linkTypeScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("linkTypeScheme"), String.class, getLinkTypeScheme(), this);
		}
		

		LinkType.LinkTypeBuilder prune();
	}

	/*********************** Immutable Implementation of LinkType  ***********************/
	class LinkTypeImpl implements LinkType {
		private final String value;
		private final String linkTypeScheme;
		
		protected LinkTypeImpl(LinkType.LinkTypeBuilder builder) {
			this.value = builder.getValue();
			this.linkTypeScheme = builder.getLinkTypeScheme();
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
		@RosettaAttribute("linkTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("linkTypeScheme")
		public String getLinkTypeScheme() {
			return linkTypeScheme;
		}
		
		@Override
		public LinkType build() {
			return this;
		}
		
		@Override
		public LinkType.LinkTypeBuilder toBuilder() {
			LinkType.LinkTypeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LinkType.LinkTypeBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getLinkTypeScheme()).ifPresent(builder::setLinkTypeScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LinkType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(linkTypeScheme, _that.getLinkTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (linkTypeScheme != null ? linkTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LinkType {" +
				"value=" + this.value + ", " +
				"linkTypeScheme=" + this.linkTypeScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of LinkType  ***********************/
	class LinkTypeBuilderImpl implements LinkType.LinkTypeBuilder {
	
		protected String value;
		protected String linkTypeScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("linkTypeScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("linkTypeScheme")
		public String getLinkTypeScheme() {
			return linkTypeScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public LinkType.LinkTypeBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("linkTypeScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("linkTypeScheme")
		@Override
		public LinkType.LinkTypeBuilder setLinkTypeScheme(String _linkTypeScheme) {
			this.linkTypeScheme = _linkTypeScheme == null ? null : _linkTypeScheme;
			return this;
		}
		
		@Override
		public LinkType build() {
			return new LinkType.LinkTypeImpl(this);
		}
		
		@Override
		public LinkType.LinkTypeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LinkType.LinkTypeBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getLinkTypeScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LinkType.LinkTypeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LinkType.LinkTypeBuilder o = (LinkType.LinkTypeBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getLinkTypeScheme(), o.getLinkTypeScheme(), this::setLinkTypeScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LinkType _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(linkTypeScheme, _that.getLinkTypeScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (linkTypeScheme != null ? linkTypeScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LinkTypeBuilder {" +
				"value=" + this.value + ", " +
				"linkTypeScheme=" + this.linkTypeScheme +
			'}';
		}
	}
}
