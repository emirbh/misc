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
import fpml.consolidated.doc.meta.AdditionalDataMeta;
import fpml.consolidated.shared.MimeType;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision Provides extra information not represented in the model that may be useful in processing the message i.e. diagnosing the reason for failure.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision Provides extra information not represented in the model that may be useful in processing the message i.e. diagnosing the reason for failure.
 *
 */
@RosettaDataType(value="AdditionalData", builder=AdditionalData.AdditionalDataBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AdditionalData", model="fpml", builder=AdditionalData.AdditionalDataBuilderImpl.class, version="2.1.1")
public interface AdditionalData extends RosettaModelObject {

	AdditionalDataMeta metaData = new AdditionalDataMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Indicates the type of media used to provide the extra information. mimeType is used to determine the software product(s) that can read the content. MIME Types are described in RFC 2046.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Indicates the type of media used to provide the extra information. mimeType is used to determine the software product(s) that can read the content. MIME Types are described in RFC 2046.
	 *
	 */
	MimeType getMimeType();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides extra information as string. In case the extra information is in XML format, a CDATA section must be placed around the source message to prevent its interpretation as XML content.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides extra information as string. In case the extra information is in XML format, a CDATA section must be placed around the source message to prevent its interpretation as XML content.
	 *
	 */
	String getString();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides extra information as binary contents coded in hexadecimal.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides extra information as binary contents coded in hexadecimal.
	 *
	 */
	String getHexadecimalBinary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides extra information as binary contents coded in base64.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides extra information as binary contents coded in base64.
	 *
	 */
	String getBase64Binary();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Provides the content of the original message.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Provides the content of the original message.
	 *
	 */
	UnprocessedElementWrapper getOriginalMessage();

	/*********************** Build Methods  ***********************/
	AdditionalData build();
	
	AdditionalData.AdditionalDataBuilder toBuilder();
	
	static AdditionalData.AdditionalDataBuilder builder() {
		return new AdditionalData.AdditionalDataBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AdditionalData> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AdditionalData> getType() {
		return AdditionalData.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("mimeType"), processor, MimeType.class, getMimeType());
		processor.processBasic(path.newSubPath("string"), String.class, getString(), this);
		processor.processBasic(path.newSubPath("hexadecimalBinary"), String.class, getHexadecimalBinary(), this);
		processor.processBasic(path.newSubPath("base64Binary"), String.class, getBase64Binary(), this);
		processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.class, getOriginalMessage());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AdditionalDataBuilder extends AdditionalData, RosettaModelObjectBuilder {
		MimeType.MimeTypeBuilder getOrCreateMimeType();
		@Override
		MimeType.MimeTypeBuilder getMimeType();
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage();
		@Override
		UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage();
		AdditionalData.AdditionalDataBuilder setMimeType(MimeType mimeType);
		AdditionalData.AdditionalDataBuilder setString(String string);
		AdditionalData.AdditionalDataBuilder setHexadecimalBinary(String hexadecimalBinary);
		AdditionalData.AdditionalDataBuilder setBase64Binary(String base64Binary);
		AdditionalData.AdditionalDataBuilder setOriginalMessage(UnprocessedElementWrapper originalMessage);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("mimeType"), processor, MimeType.MimeTypeBuilder.class, getMimeType());
			processor.processBasic(path.newSubPath("string"), String.class, getString(), this);
			processor.processBasic(path.newSubPath("hexadecimalBinary"), String.class, getHexadecimalBinary(), this);
			processor.processBasic(path.newSubPath("base64Binary"), String.class, getBase64Binary(), this);
			processRosetta(path.newSubPath("originalMessage"), processor, UnprocessedElementWrapper.UnprocessedElementWrapperBuilder.class, getOriginalMessage());
		}
		

		AdditionalData.AdditionalDataBuilder prune();
	}

	/*********************** Immutable Implementation of AdditionalData  ***********************/
	class AdditionalDataImpl implements AdditionalData {
		private final MimeType mimeType;
		private final String string;
		private final String hexadecimalBinary;
		private final String base64Binary;
		private final UnprocessedElementWrapper originalMessage;
		
		protected AdditionalDataImpl(AdditionalData.AdditionalDataBuilder builder) {
			this.mimeType = ofNullable(builder.getMimeType()).map(f->f.build()).orElse(null);
			this.string = builder.getString();
			this.hexadecimalBinary = builder.getHexadecimalBinary();
			this.base64Binary = builder.getBase64Binary();
			this.originalMessage = ofNullable(builder.getOriginalMessage()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("mimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mimeType")
		public MimeType getMimeType() {
			return mimeType;
		}
		
		@Override
		@RosettaAttribute("string")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("string")
		public String getString() {
			return string;
		}
		
		@Override
		@RosettaAttribute("hexadecimalBinary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hexadecimalBinary")
		public String getHexadecimalBinary() {
			return hexadecimalBinary;
		}
		
		@Override
		@RosettaAttribute("base64Binary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("base64Binary")
		public String getBase64Binary() {
			return base64Binary;
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalMessage")
		public UnprocessedElementWrapper getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		public AdditionalData build() {
			return this;
		}
		
		@Override
		public AdditionalData.AdditionalDataBuilder toBuilder() {
			AdditionalData.AdditionalDataBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AdditionalData.AdditionalDataBuilder builder) {
			ofNullable(getMimeType()).ifPresent(builder::setMimeType);
			ofNullable(getString()).ifPresent(builder::setString);
			ofNullable(getHexadecimalBinary()).ifPresent(builder::setHexadecimalBinary);
			ofNullable(getBase64Binary()).ifPresent(builder::setBase64Binary);
			ofNullable(getOriginalMessage()).ifPresent(builder::setOriginalMessage);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalData _that = getType().cast(o);
		
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(string, _that.getString())) return false;
			if (!Objects.equals(hexadecimalBinary, _that.getHexadecimalBinary())) return false;
			if (!Objects.equals(base64Binary, _that.getBase64Binary())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (string != null ? string.hashCode() : 0);
			_result = 31 * _result + (hexadecimalBinary != null ? hexadecimalBinary.hashCode() : 0);
			_result = 31 * _result + (base64Binary != null ? base64Binary.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalData {" +
				"mimeType=" + this.mimeType + ", " +
				"string=" + this.string + ", " +
				"hexadecimalBinary=" + this.hexadecimalBinary + ", " +
				"base64Binary=" + this.base64Binary + ", " +
				"originalMessage=" + this.originalMessage +
			'}';
		}
	}

	/*********************** Builder Implementation of AdditionalData  ***********************/
	class AdditionalDataBuilderImpl implements AdditionalData.AdditionalDataBuilder {
	
		protected MimeType.MimeTypeBuilder mimeType;
		protected String string;
		protected String hexadecimalBinary;
		protected String base64Binary;
		protected UnprocessedElementWrapper.UnprocessedElementWrapperBuilder originalMessage;
		
		@Override
		@RosettaAttribute("mimeType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("mimeType")
		public MimeType.MimeTypeBuilder getMimeType() {
			return mimeType;
		}
		
		@Override
		public MimeType.MimeTypeBuilder getOrCreateMimeType() {
			MimeType.MimeTypeBuilder result;
			if (mimeType!=null) {
				result = mimeType;
			}
			else {
				result = mimeType = MimeType.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("string")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("string")
		public String getString() {
			return string;
		}
		
		@Override
		@RosettaAttribute("hexadecimalBinary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("hexadecimalBinary")
		public String getHexadecimalBinary() {
			return hexadecimalBinary;
		}
		
		@Override
		@RosettaAttribute("base64Binary")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("base64Binary")
		public String getBase64Binary() {
			return base64Binary;
		}
		
		@Override
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("originalMessage")
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOriginalMessage() {
			return originalMessage;
		}
		
		@Override
		public UnprocessedElementWrapper.UnprocessedElementWrapperBuilder getOrCreateOriginalMessage() {
			UnprocessedElementWrapper.UnprocessedElementWrapperBuilder result;
			if (originalMessage!=null) {
				result = originalMessage;
			}
			else {
				result = originalMessage = UnprocessedElementWrapper.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("mimeType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("mimeType")
		@Override
		public AdditionalData.AdditionalDataBuilder setMimeType(MimeType _mimeType) {
			this.mimeType = _mimeType == null ? null : _mimeType.toBuilder();
			return this;
		}
		
		@RosettaAttribute("string")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("string")
		@Override
		public AdditionalData.AdditionalDataBuilder setString(String _string) {
			this.string = _string == null ? null : _string;
			return this;
		}
		
		@RosettaAttribute("hexadecimalBinary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("hexadecimalBinary")
		@Override
		public AdditionalData.AdditionalDataBuilder setHexadecimalBinary(String _hexadecimalBinary) {
			this.hexadecimalBinary = _hexadecimalBinary == null ? null : _hexadecimalBinary;
			return this;
		}
		
		@RosettaAttribute("base64Binary")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("base64Binary")
		@Override
		public AdditionalData.AdditionalDataBuilder setBase64Binary(String _base64Binary) {
			this.base64Binary = _base64Binary == null ? null : _base64Binary;
			return this;
		}
		
		@RosettaAttribute("originalMessage")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("originalMessage")
		@Override
		public AdditionalData.AdditionalDataBuilder setOriginalMessage(UnprocessedElementWrapper _originalMessage) {
			this.originalMessage = _originalMessage == null ? null : _originalMessage.toBuilder();
			return this;
		}
		
		@Override
		public AdditionalData build() {
			return new AdditionalData.AdditionalDataImpl(this);
		}
		
		@Override
		public AdditionalData.AdditionalDataBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalData.AdditionalDataBuilder prune() {
			if (mimeType!=null && !mimeType.prune().hasData()) mimeType = null;
			if (originalMessage!=null && !originalMessage.prune().hasData()) originalMessage = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMimeType()!=null && getMimeType().hasData()) return true;
			if (getString()!=null) return true;
			if (getHexadecimalBinary()!=null) return true;
			if (getBase64Binary()!=null) return true;
			if (getOriginalMessage()!=null && getOriginalMessage().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AdditionalData.AdditionalDataBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AdditionalData.AdditionalDataBuilder o = (AdditionalData.AdditionalDataBuilder) other;
			
			merger.mergeRosetta(getMimeType(), o.getMimeType(), this::setMimeType);
			merger.mergeRosetta(getOriginalMessage(), o.getOriginalMessage(), this::setOriginalMessage);
			
			merger.mergeBasic(getString(), o.getString(), this::setString);
			merger.mergeBasic(getHexadecimalBinary(), o.getHexadecimalBinary(), this::setHexadecimalBinary);
			merger.mergeBasic(getBase64Binary(), o.getBase64Binary(), this::setBase64Binary);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AdditionalData _that = getType().cast(o);
		
			if (!Objects.equals(mimeType, _that.getMimeType())) return false;
			if (!Objects.equals(string, _that.getString())) return false;
			if (!Objects.equals(hexadecimalBinary, _that.getHexadecimalBinary())) return false;
			if (!Objects.equals(base64Binary, _that.getBase64Binary())) return false;
			if (!Objects.equals(originalMessage, _that.getOriginalMessage())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (mimeType != null ? mimeType.hashCode() : 0);
			_result = 31 * _result + (string != null ? string.hashCode() : 0);
			_result = 31 * _result + (hexadecimalBinary != null ? hexadecimalBinary.hashCode() : 0);
			_result = 31 * _result + (base64Binary != null ? base64Binary.hashCode() : 0);
			_result = 31 * _result + (originalMessage != null ? originalMessage.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AdditionalDataBuilder {" +
				"mimeType=" + this.mimeType + ", " +
				"string=" + this.string + ", " +
				"hexadecimalBinary=" + this.hexadecimalBinary + ", " +
				"base64Binary=" + this.base64Binary + ", " +
				"originalMessage=" + this.originalMessage +
			'}';
		}
	}
}
