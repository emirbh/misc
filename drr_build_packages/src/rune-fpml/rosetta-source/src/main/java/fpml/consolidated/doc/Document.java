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
import fpml.consolidated.doc.meta.DocumentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The abstract base type from which all FpML compliant messages and documents must be derived.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The abstract base type from which all FpML compliant messages and documents must be derived.
 *
 */
@RosettaDataType(value="Document", builder=Document.DocumentBuilderImpl.class, version="2.1.1")
@RuneDataType(value="Document", model="fpml", builder=Document.DocumentBuilderImpl.class, version="2.1.1")
public interface Document extends RosettaModelObject {

	DocumentMeta metaData = new DocumentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicate which version of the FpML Schema an FpML message adheres to.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicate which version of the FpML Schema an FpML message adheres to.
	 *
	 */
	String getFpmlVersion();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision This optional attribute can be supplied by a message creator in an FpML instance to specify which build number of the schema was used to define the message when it was generated.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision This optional attribute can be supplied by a message creator in an FpML instance to specify which build number of the schema was used to define the message when it was generated.
	 *
	 */
	Integer getExpectedBuild();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The specific build number of this schema version. This attribute is not included in an instance document. Instead, it is supplied by the XML parser when the document is validated against the FpML schema and indicates the build number of the schema file. Every time FpML publishes a change to the schema, validation rules, or examples within a version (e.g., version 4.2) the actual build number is incremented. If no changes have been made between releases within a version (i.e. from Trial Recommendation to Recommendation) the actual build number stays the same.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The specific build number of this schema version. This attribute is not included in an instance document. Instead, it is supplied by the XML parser when the document is validated against the FpML schema and indicates the build number of the schema file. Every time FpML publishes a change to the schema, validation rules, or examples within a version (e.g., version 4.2) the actual build number is incremented. If no changes have been made between releases within a version (i.e. from Trial Recommendation to Recommendation) the actual build number stays the same.
	 *
	 */
	Integer getActualBuild();

	/*********************** Build Methods  ***********************/
	Document build();
	
	Document.DocumentBuilder toBuilder();
	
	static Document.DocumentBuilder builder() {
		return new Document.DocumentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Document> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Document> getType() {
		return Document.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface DocumentBuilder extends Document, RosettaModelObjectBuilder {
		Document.DocumentBuilder setFpmlVersion(String fpmlVersion);
		Document.DocumentBuilder setExpectedBuild(Integer expectedBuild);
		Document.DocumentBuilder setActualBuild(Integer actualBuild);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		}
		

		Document.DocumentBuilder prune();
	}

	/*********************** Immutable Implementation of Document  ***********************/
	class DocumentImpl implements Document {
		private final String fpmlVersion;
		private final Integer expectedBuild;
		private final Integer actualBuild;
		
		protected DocumentImpl(Document.DocumentBuilder builder) {
			this.fpmlVersion = builder.getFpmlVersion();
			this.expectedBuild = builder.getExpectedBuild();
			this.actualBuild = builder.getActualBuild();
		}
		
		@Override
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		public String getFpmlVersion() {
			return fpmlVersion;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expectedBuild")
		public Integer getExpectedBuild() {
			return expectedBuild;
		}
		
		@Override
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actualBuild")
		public Integer getActualBuild() {
			return actualBuild;
		}
		
		@Override
		public Document build() {
			return this;
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			Document.DocumentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Document.DocumentBuilder builder) {
			ofNullable(getFpmlVersion()).ifPresent(builder::setFpmlVersion);
			ofNullable(getExpectedBuild()).ifPresent(builder::setExpectedBuild);
			ofNullable(getActualBuild()).ifPresent(builder::setActualBuild);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(fpmlVersion, _that.getFpmlVersion())) return false;
			if (!Objects.equals(expectedBuild, _that.getExpectedBuild())) return false;
			if (!Objects.equals(actualBuild, _that.getActualBuild())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fpmlVersion != null ? fpmlVersion.hashCode() : 0);
			_result = 31 * _result + (expectedBuild != null ? expectedBuild.hashCode() : 0);
			_result = 31 * _result + (actualBuild != null ? actualBuild.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Document {" +
				"fpmlVersion=" + this.fpmlVersion + ", " +
				"expectedBuild=" + this.expectedBuild + ", " +
				"actualBuild=" + this.actualBuild +
			'}';
		}
	}

	/*********************** Builder Implementation of Document  ***********************/
	class DocumentBuilderImpl implements Document.DocumentBuilder {
	
		protected String fpmlVersion;
		protected Integer expectedBuild;
		protected Integer actualBuild;
		
		@Override
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		public String getFpmlVersion() {
			return fpmlVersion;
		}
		
		@Override
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expectedBuild")
		public Integer getExpectedBuild() {
			return expectedBuild;
		}
		
		@Override
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("actualBuild")
		public Integer getActualBuild() {
			return actualBuild;
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public Document.DocumentBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public Document.DocumentBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public Document.DocumentBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@Override
		public Document build() {
			return new Document.DocumentImpl(this);
		}
		
		@Override
		public Document.DocumentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFpmlVersion()!=null) return true;
			if (getExpectedBuild()!=null) return true;
			if (getActualBuild()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Document.DocumentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Document.DocumentBuilder o = (Document.DocumentBuilder) other;
			
			
			merger.mergeBasic(getFpmlVersion(), o.getFpmlVersion(), this::setFpmlVersion);
			merger.mergeBasic(getExpectedBuild(), o.getExpectedBuild(), this::setExpectedBuild);
			merger.mergeBasic(getActualBuild(), o.getActualBuild(), this::setActualBuild);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Document _that = getType().cast(o);
		
			if (!Objects.equals(fpmlVersion, _that.getFpmlVersion())) return false;
			if (!Objects.equals(expectedBuild, _that.getExpectedBuild())) return false;
			if (!Objects.equals(actualBuild, _that.getActualBuild())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fpmlVersion != null ? fpmlVersion.hashCode() : 0);
			_result = 31 * _result + (expectedBuild != null ? expectedBuild.hashCode() : 0);
			_result = 31 * _result + (actualBuild != null ? actualBuild.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DocumentBuilder {" +
				"fpmlVersion=" + this.fpmlVersion + ", " +
				"expectedBuild=" + this.expectedBuild + ", " +
				"actualBuild=" + this.actualBuild +
			'}';
		}
	}
}
