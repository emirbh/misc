package iso20022.dtcc.rds.harmonized;

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
import iso20022.dtcc.rds.harmonized.meta.HeaderMeta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="Header", builder=Header.HeaderBuilderImpl.class, version="${project.version}")
@RuneDataType(value="Header", model="iso20022", builder=Header.HeaderBuilderImpl.class, version="${project.version}")
public interface Header extends RosettaModelObject {

	HeaderMeta metaData = new HeaderMeta();

	/*********************** Getter Methods  ***********************/
	String getRdsSchemaVersion();
	String getSender();
	String getReceiver();
	String getDocumentTrackingId();
	ZonedDateTime getDocumentCreationTimestamp();

	/*********************** Build Methods  ***********************/
	Header build();
	
	Header.HeaderBuilder toBuilder();
	
	static Header.HeaderBuilder builder() {
		return new Header.HeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Header> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Header> getType() {
		return Header.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rdsSchemaVersion"), String.class, getRdsSchemaVersion(), this);
		processor.processBasic(path.newSubPath("sender"), String.class, getSender(), this);
		processor.processBasic(path.newSubPath("receiver"), String.class, getReceiver(), this);
		processor.processBasic(path.newSubPath("documentTrackingId"), String.class, getDocumentTrackingId(), this);
		processor.processBasic(path.newSubPath("documentCreationTimestamp"), ZonedDateTime.class, getDocumentCreationTimestamp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface HeaderBuilder extends Header, RosettaModelObjectBuilder {
		Header.HeaderBuilder setRdsSchemaVersion(String rdsSchemaVersion);
		Header.HeaderBuilder setSender(String sender);
		Header.HeaderBuilder setReceiver(String receiver);
		Header.HeaderBuilder setDocumentTrackingId(String documentTrackingId);
		Header.HeaderBuilder setDocumentCreationTimestamp(ZonedDateTime documentCreationTimestamp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("rdsSchemaVersion"), String.class, getRdsSchemaVersion(), this);
			processor.processBasic(path.newSubPath("sender"), String.class, getSender(), this);
			processor.processBasic(path.newSubPath("receiver"), String.class, getReceiver(), this);
			processor.processBasic(path.newSubPath("documentTrackingId"), String.class, getDocumentTrackingId(), this);
			processor.processBasic(path.newSubPath("documentCreationTimestamp"), ZonedDateTime.class, getDocumentCreationTimestamp(), this);
		}
		

		Header.HeaderBuilder prune();
	}

	/*********************** Immutable Implementation of Header  ***********************/
	class HeaderImpl implements Header {
		private final String rdsSchemaVersion;
		private final String sender;
		private final String receiver;
		private final String documentTrackingId;
		private final ZonedDateTime documentCreationTimestamp;
		
		protected HeaderImpl(Header.HeaderBuilder builder) {
			this.rdsSchemaVersion = builder.getRdsSchemaVersion();
			this.sender = builder.getSender();
			this.receiver = builder.getReceiver();
			this.documentTrackingId = builder.getDocumentTrackingId();
			this.documentCreationTimestamp = builder.getDocumentCreationTimestamp();
		}
		
		@Override
		@RosettaAttribute("rdsSchemaVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rdsSchemaVersion")
		public String getRdsSchemaVersion() {
			return rdsSchemaVersion;
		}
		
		@Override
		@RosettaAttribute("sender")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sender")
		public String getSender() {
			return sender;
		}
		
		@Override
		@RosettaAttribute("receiver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiver")
		public String getReceiver() {
			return receiver;
		}
		
		@Override
		@RosettaAttribute("documentTrackingId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("documentTrackingId")
		public String getDocumentTrackingId() {
			return documentTrackingId;
		}
		
		@Override
		@RosettaAttribute("documentCreationTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentCreationTimestamp")
		public ZonedDateTime getDocumentCreationTimestamp() {
			return documentCreationTimestamp;
		}
		
		@Override
		public Header build() {
			return this;
		}
		
		@Override
		public Header.HeaderBuilder toBuilder() {
			Header.HeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Header.HeaderBuilder builder) {
			ofNullable(getRdsSchemaVersion()).ifPresent(builder::setRdsSchemaVersion);
			ofNullable(getSender()).ifPresent(builder::setSender);
			ofNullable(getReceiver()).ifPresent(builder::setReceiver);
			ofNullable(getDocumentTrackingId()).ifPresent(builder::setDocumentTrackingId);
			ofNullable(getDocumentCreationTimestamp()).ifPresent(builder::setDocumentCreationTimestamp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Header _that = getType().cast(o);
		
			if (!Objects.equals(rdsSchemaVersion, _that.getRdsSchemaVersion())) return false;
			if (!Objects.equals(sender, _that.getSender())) return false;
			if (!Objects.equals(receiver, _that.getReceiver())) return false;
			if (!Objects.equals(documentTrackingId, _that.getDocumentTrackingId())) return false;
			if (!Objects.equals(documentCreationTimestamp, _that.getDocumentCreationTimestamp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rdsSchemaVersion != null ? rdsSchemaVersion.hashCode() : 0);
			_result = 31 * _result + (sender != null ? sender.hashCode() : 0);
			_result = 31 * _result + (receiver != null ? receiver.hashCode() : 0);
			_result = 31 * _result + (documentTrackingId != null ? documentTrackingId.hashCode() : 0);
			_result = 31 * _result + (documentCreationTimestamp != null ? documentCreationTimestamp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Header {" +
				"rdsSchemaVersion=" + this.rdsSchemaVersion + ", " +
				"sender=" + this.sender + ", " +
				"receiver=" + this.receiver + ", " +
				"documentTrackingId=" + this.documentTrackingId + ", " +
				"documentCreationTimestamp=" + this.documentCreationTimestamp +
			'}';
		}
	}

	/*********************** Builder Implementation of Header  ***********************/
	class HeaderBuilderImpl implements Header.HeaderBuilder {
	
		protected String rdsSchemaVersion;
		protected String sender;
		protected String receiver;
		protected String documentTrackingId;
		protected ZonedDateTime documentCreationTimestamp;
		
		@Override
		@RosettaAttribute("rdsSchemaVersion")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("rdsSchemaVersion")
		public String getRdsSchemaVersion() {
			return rdsSchemaVersion;
		}
		
		@Override
		@RosettaAttribute("sender")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sender")
		public String getSender() {
			return sender;
		}
		
		@Override
		@RosettaAttribute("receiver")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("receiver")
		public String getReceiver() {
			return receiver;
		}
		
		@Override
		@RosettaAttribute("documentTrackingId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("documentTrackingId")
		public String getDocumentTrackingId() {
			return documentTrackingId;
		}
		
		@Override
		@RosettaAttribute("documentCreationTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("documentCreationTimestamp")
		public ZonedDateTime getDocumentCreationTimestamp() {
			return documentCreationTimestamp;
		}
		
		@RosettaAttribute("rdsSchemaVersion")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("rdsSchemaVersion")
		@Override
		public Header.HeaderBuilder setRdsSchemaVersion(String _rdsSchemaVersion) {
			this.rdsSchemaVersion = _rdsSchemaVersion == null ? null : _rdsSchemaVersion;
			return this;
		}
		
		@RosettaAttribute("sender")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sender")
		@Override
		public Header.HeaderBuilder setSender(String _sender) {
			this.sender = _sender == null ? null : _sender;
			return this;
		}
		
		@RosettaAttribute("receiver")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("receiver")
		@Override
		public Header.HeaderBuilder setReceiver(String _receiver) {
			this.receiver = _receiver == null ? null : _receiver;
			return this;
		}
		
		@RosettaAttribute("documentTrackingId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("documentTrackingId")
		@Override
		public Header.HeaderBuilder setDocumentTrackingId(String _documentTrackingId) {
			this.documentTrackingId = _documentTrackingId == null ? null : _documentTrackingId;
			return this;
		}
		
		@RosettaAttribute("documentCreationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("documentCreationTimestamp")
		@Override
		public Header.HeaderBuilder setDocumentCreationTimestamp(ZonedDateTime _documentCreationTimestamp) {
			this.documentCreationTimestamp = _documentCreationTimestamp == null ? null : _documentCreationTimestamp;
			return this;
		}
		
		@Override
		public Header build() {
			return new Header.HeaderImpl(this);
		}
		
		@Override
		public Header.HeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Header.HeaderBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRdsSchemaVersion()!=null) return true;
			if (getSender()!=null) return true;
			if (getReceiver()!=null) return true;
			if (getDocumentTrackingId()!=null) return true;
			if (getDocumentCreationTimestamp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Header.HeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Header.HeaderBuilder o = (Header.HeaderBuilder) other;
			
			
			merger.mergeBasic(getRdsSchemaVersion(), o.getRdsSchemaVersion(), this::setRdsSchemaVersion);
			merger.mergeBasic(getSender(), o.getSender(), this::setSender);
			merger.mergeBasic(getReceiver(), o.getReceiver(), this::setReceiver);
			merger.mergeBasic(getDocumentTrackingId(), o.getDocumentTrackingId(), this::setDocumentTrackingId);
			merger.mergeBasic(getDocumentCreationTimestamp(), o.getDocumentCreationTimestamp(), this::setDocumentCreationTimestamp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Header _that = getType().cast(o);
		
			if (!Objects.equals(rdsSchemaVersion, _that.getRdsSchemaVersion())) return false;
			if (!Objects.equals(sender, _that.getSender())) return false;
			if (!Objects.equals(receiver, _that.getReceiver())) return false;
			if (!Objects.equals(documentTrackingId, _that.getDocumentTrackingId())) return false;
			if (!Objects.equals(documentCreationTimestamp, _that.getDocumentCreationTimestamp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (rdsSchemaVersion != null ? rdsSchemaVersion.hashCode() : 0);
			_result = 31 * _result + (sender != null ? sender.hashCode() : 0);
			_result = 31 * _result + (receiver != null ? receiver.hashCode() : 0);
			_result = 31 * _result + (documentTrackingId != null ? documentTrackingId.hashCode() : 0);
			_result = 31 * _result + (documentCreationTimestamp != null ? documentCreationTimestamp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "HeaderBuilder {" +
				"rdsSchemaVersion=" + this.rdsSchemaVersion + ", " +
				"sender=" + this.sender + ", " +
				"receiver=" + this.receiver + ", " +
				"documentTrackingId=" + this.documentTrackingId + ", " +
				"documentCreationTimestamp=" + this.documentCreationTimestamp +
			'}';
		}
	}
}
