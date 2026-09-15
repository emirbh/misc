package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbUpiRecordMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbUpiRecord", builder=AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbUpiRecord", model="drr", builder=AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilderImpl.class, version="7.7.0")
public interface AnnaDsbUpiRecord extends RosettaModelObject {

	AnnaDsbUpiRecordMeta metaData = new AnnaDsbUpiRecordMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbIdentifier getIdentifier();
	AnnaDsbHeader getHeader();
	AnnaDsbDerived getDerived();
	AnnaDsbAttributesRecord getAttributes();
	Integer getTemplateVersion();

	/*********************** Build Methods  ***********************/
	AnnaDsbUpiRecord build();
	
	AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder toBuilder();
	
	static AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder builder() {
		return new AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbUpiRecord> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbUpiRecord> getType() {
		return AnnaDsbUpiRecord.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("Identifier"), processor, AnnaDsbIdentifier.class, getIdentifier());
		processRosetta(path.newSubPath("Header"), processor, AnnaDsbHeader.class, getHeader());
		processRosetta(path.newSubPath("Derived"), processor, AnnaDsbDerived.class, getDerived());
		processRosetta(path.newSubPath("Attributes"), processor, AnnaDsbAttributesRecord.class, getAttributes());
		processor.processBasic(path.newSubPath("TemplateVersion"), Integer.class, getTemplateVersion(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbUpiRecordBuilder extends AnnaDsbUpiRecord, RosettaModelObjectBuilder {
		AnnaDsbIdentifier.AnnaDsbIdentifierBuilder getOrCreateIdentifier();
		@Override
		AnnaDsbIdentifier.AnnaDsbIdentifierBuilder getIdentifier();
		AnnaDsbHeader.AnnaDsbHeaderBuilder getOrCreateHeader();
		@Override
		AnnaDsbHeader.AnnaDsbHeaderBuilder getHeader();
		AnnaDsbDerived.AnnaDsbDerivedBuilder getOrCreateDerived();
		@Override
		AnnaDsbDerived.AnnaDsbDerivedBuilder getDerived();
		AnnaDsbAttributesRecord.AnnaDsbAttributesRecordBuilder getOrCreateAttributes();
		@Override
		AnnaDsbAttributesRecord.AnnaDsbAttributesRecordBuilder getAttributes();
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setIdentifier(AnnaDsbIdentifier Identifier);
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setHeader(AnnaDsbHeader Header);
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setDerived(AnnaDsbDerived Derived);
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setAttributes(AnnaDsbAttributesRecord Attributes);
		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setTemplateVersion(Integer TemplateVersion);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("Identifier"), processor, AnnaDsbIdentifier.AnnaDsbIdentifierBuilder.class, getIdentifier());
			processRosetta(path.newSubPath("Header"), processor, AnnaDsbHeader.AnnaDsbHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("Derived"), processor, AnnaDsbDerived.AnnaDsbDerivedBuilder.class, getDerived());
			processRosetta(path.newSubPath("Attributes"), processor, AnnaDsbAttributesRecord.AnnaDsbAttributesRecordBuilder.class, getAttributes());
			processor.processBasic(path.newSubPath("TemplateVersion"), Integer.class, getTemplateVersion(), this);
		}
		

		AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbUpiRecord  ***********************/
	class AnnaDsbUpiRecordImpl implements AnnaDsbUpiRecord {
		private final AnnaDsbIdentifier identifier;
		private final AnnaDsbHeader header;
		private final AnnaDsbDerived derived;
		private final AnnaDsbAttributesRecord attributes;
		private final Integer templateVersion;
		
		protected AnnaDsbUpiRecordImpl(AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder builder) {
			this.identifier = ofNullable(builder.getIdentifier()).map(f->f.build()).orElse(null);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.derived = ofNullable(builder.getDerived()).map(f->f.build()).orElse(null);
			this.attributes = ofNullable(builder.getAttributes()).map(f->f.build()).orElse(null);
			this.templateVersion = builder.getTemplateVersion();
		}
		
		@Override
		@RosettaAttribute("Identifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Identifier")
		public AnnaDsbIdentifier getIdentifier() {
			return identifier;
		}
		
		@Override
		@RosettaAttribute("Header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Header")
		public AnnaDsbHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("Derived")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Derived")
		public AnnaDsbDerived getDerived() {
			return derived;
		}
		
		@Override
		@RosettaAttribute("Attributes")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Attributes")
		public AnnaDsbAttributesRecord getAttributes() {
			return attributes;
		}
		
		@Override
		@RosettaAttribute("TemplateVersion")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("TemplateVersion")
		public Integer getTemplateVersion() {
			return templateVersion;
		}
		
		@Override
		public AnnaDsbUpiRecord build() {
			return this;
		}
		
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder toBuilder() {
			AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder builder) {
			ofNullable(getIdentifier()).ifPresent(builder::setIdentifier);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getDerived()).ifPresent(builder::setDerived);
			ofNullable(getAttributes()).ifPresent(builder::setAttributes);
			ofNullable(getTemplateVersion()).ifPresent(builder::setTemplateVersion);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUpiRecord _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(derived, _that.getDerived())) return false;
			if (!Objects.equals(attributes, _that.getAttributes())) return false;
			if (!Objects.equals(templateVersion, _that.getTemplateVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (derived != null ? derived.hashCode() : 0);
			_result = 31 * _result + (attributes != null ? attributes.hashCode() : 0);
			_result = 31 * _result + (templateVersion != null ? templateVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUpiRecord {" +
				"Identifier=" + this.identifier + ", " +
				"Header=" + this.header + ", " +
				"Derived=" + this.derived + ", " +
				"Attributes=" + this.attributes + ", " +
				"TemplateVersion=" + this.templateVersion +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbUpiRecord  ***********************/
	class AnnaDsbUpiRecordBuilderImpl implements AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder {
	
		protected AnnaDsbIdentifier.AnnaDsbIdentifierBuilder identifier;
		protected AnnaDsbHeader.AnnaDsbHeaderBuilder header;
		protected AnnaDsbDerived.AnnaDsbDerivedBuilder derived;
		protected AnnaDsbAttributesRecord.AnnaDsbAttributesRecordBuilder attributes;
		protected Integer templateVersion;
		
		@Override
		@RosettaAttribute("Identifier")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Identifier")
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder getIdentifier() {
			return identifier;
		}
		
		@Override
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder getOrCreateIdentifier() {
			AnnaDsbIdentifier.AnnaDsbIdentifierBuilder result;
			if (identifier!=null) {
				result = identifier;
			}
			else {
				result = identifier = AnnaDsbIdentifier.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Header")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Header")
		public AnnaDsbHeader.AnnaDsbHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public AnnaDsbHeader.AnnaDsbHeaderBuilder getOrCreateHeader() {
			AnnaDsbHeader.AnnaDsbHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = AnnaDsbHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Derived")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Derived")
		public AnnaDsbDerived.AnnaDsbDerivedBuilder getDerived() {
			return derived;
		}
		
		@Override
		public AnnaDsbDerived.AnnaDsbDerivedBuilder getOrCreateDerived() {
			AnnaDsbDerived.AnnaDsbDerivedBuilder result;
			if (derived!=null) {
				result = derived;
			}
			else {
				result = derived = AnnaDsbDerived.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("Attributes")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Attributes")
		public AnnaDsbAttributesRecord.AnnaDsbAttributesRecordBuilder getAttributes() {
			return attributes;
		}
		
		@Override
		public AnnaDsbAttributesRecord.AnnaDsbAttributesRecordBuilder getOrCreateAttributes() {
			AnnaDsbAttributesRecord.AnnaDsbAttributesRecordBuilder result;
			if (attributes!=null) {
				result = attributes;
			}
			else {
				result = attributes = AnnaDsbAttributesRecord.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("TemplateVersion")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("TemplateVersion")
		public Integer getTemplateVersion() {
			return templateVersion;
		}
		
		@RosettaAttribute("Identifier")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("Identifier")
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setIdentifier(AnnaDsbIdentifier _identifier) {
			this.identifier = _identifier == null ? null : _identifier.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Header")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("Header")
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setHeader(AnnaDsbHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Derived")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("Derived")
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setDerived(AnnaDsbDerived _derived) {
			this.derived = _derived == null ? null : _derived.toBuilder();
			return this;
		}
		
		@RosettaAttribute("Attributes")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("Attributes")
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setAttributes(AnnaDsbAttributesRecord _attributes) {
			this.attributes = _attributes == null ? null : _attributes.toBuilder();
			return this;
		}
		
		@RosettaAttribute("TemplateVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("TemplateVersion")
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder setTemplateVersion(Integer _templateVersion) {
			this.templateVersion = _templateVersion == null ? null : _templateVersion;
			return this;
		}
		
		@Override
		public AnnaDsbUpiRecord build() {
			return new AnnaDsbUpiRecord.AnnaDsbUpiRecordImpl(this);
		}
		
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder prune() {
			if (identifier!=null && !identifier.prune().hasData()) identifier = null;
			if (header!=null && !header.prune().hasData()) header = null;
			if (derived!=null && !derived.prune().hasData()) derived = null;
			if (attributes!=null && !attributes.prune().hasData()) attributes = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIdentifier()!=null && getIdentifier().hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getDerived()!=null && getDerived().hasData()) return true;
			if (getAttributes()!=null && getAttributes().hasData()) return true;
			if (getTemplateVersion()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder o = (AnnaDsbUpiRecord.AnnaDsbUpiRecordBuilder) other;
			
			merger.mergeRosetta(getIdentifier(), o.getIdentifier(), this::setIdentifier);
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getDerived(), o.getDerived(), this::setDerived);
			merger.mergeRosetta(getAttributes(), o.getAttributes(), this::setAttributes);
			
			merger.mergeBasic(getTemplateVersion(), o.getTemplateVersion(), this::setTemplateVersion);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbUpiRecord _that = getType().cast(o);
		
			if (!Objects.equals(identifier, _that.getIdentifier())) return false;
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!Objects.equals(derived, _that.getDerived())) return false;
			if (!Objects.equals(attributes, _that.getAttributes())) return false;
			if (!Objects.equals(templateVersion, _that.getTemplateVersion())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (identifier != null ? identifier.hashCode() : 0);
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (derived != null ? derived.hashCode() : 0);
			_result = 31 * _result + (attributes != null ? attributes.hashCode() : 0);
			_result = 31 * _result + (templateVersion != null ? templateVersion.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbUpiRecordBuilder {" +
				"Identifier=" + this.identifier + ", " +
				"Header=" + this.header + ", " +
				"Derived=" + this.derived + ", " +
				"Attributes=" + this.attributes + ", " +
				"TemplateVersion=" + this.templateVersion +
			'}';
		}
	}
}
