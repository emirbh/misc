package fpml.consolidated.msg;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.consolidated.SignatureType;
import fpml.consolidated.msg.meta.ResponseMessageHeaderMeta;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type refining the generic message header to make it specific to response messages.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type refining the generic message header to make it specific to response messages.
 *
 */
@RosettaDataType(value="ResponseMessageHeader", builder=ResponseMessageHeader.ResponseMessageHeaderBuilderImpl.class, version="2.1.1")
@RuneDataType(value="ResponseMessageHeader", model="fpml", builder=ResponseMessageHeader.ResponseMessageHeaderBuilderImpl.class, version="2.1.1")
public interface ResponseMessageHeader extends MessageHeader {

	ResponseMessageHeaderMeta metaData = new ResponseMessageHeaderMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A copy of the unique message identifier (within it own coding scheme) to which this message is responding.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A copy of the unique message identifier (within it own coding scheme) to which this message is responding.
	 *
	 */
	MessageId getInReplyTo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The unique identifier (within its coding scheme) for the originator of a message instance.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The unique identifier (within its coding scheme) for the originator of a message instance.
	 *
	 */
	MessageAddress getSentBy();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A unique identifier (within its coding scheme) indicating an intended recipent of a message.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique identifier (within its coding scheme) indicating an intended recipent of a message.
	 *
	 */
	List<? extends MessageAddress> getSendTo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.
	 *
	 */
	List<? extends MessageAddress> getCopyTo();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date and time (on the source system) when this message instance was created.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date and time (on the source system) when this message instance was created.
	 *
	 */
	ZonedDateTime getCreationTimestamp();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The date and time (on the source system) when this message instance will be considered expired.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The date and time (on the source system) when this message instance will be considered expired.
	 *
	 */
	ZonedDateTime getExpiryTimestamp();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision The version(s) of specifications that the sender asserts the message was developed for.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision The version(s) of specifications that the sender asserts the message was developed for.
	 *
	 */
	ImplementationSpecification getImplementationSpecification();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Additional message information that may be provided by each involved party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision Additional message information that may be provided by each involved party.
	 *
	 */
	List<? extends PartyMessageInformation> getPartyMessageInformation();
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
	List<? extends SignatureType> getSignature();

	/*********************** Build Methods  ***********************/
	ResponseMessageHeader build();
	
	ResponseMessageHeader.ResponseMessageHeaderBuilder toBuilder();
	
	static ResponseMessageHeader.ResponseMessageHeaderBuilder builder() {
		return new ResponseMessageHeader.ResponseMessageHeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ResponseMessageHeader> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ResponseMessageHeader> getType() {
		return ResponseMessageHeader.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("messageId"), processor, MessageId.class, getMessageId());
		processRosetta(path.newSubPath("inReplyTo"), processor, MessageId.class, getInReplyTo());
		processRosetta(path.newSubPath("sentBy"), processor, MessageAddress.class, getSentBy());
		processRosetta(path.newSubPath("sendTo"), processor, MessageAddress.class, getSendTo());
		processRosetta(path.newSubPath("copyTo"), processor, MessageAddress.class, getCopyTo());
		processor.processBasic(path.newSubPath("creationTimestamp"), ZonedDateTime.class, getCreationTimestamp(), this);
		processor.processBasic(path.newSubPath("expiryTimestamp"), ZonedDateTime.class, getExpiryTimestamp(), this);
		processRosetta(path.newSubPath("implementationSpecification"), processor, ImplementationSpecification.class, getImplementationSpecification());
		processRosetta(path.newSubPath("partyMessageInformation"), processor, PartyMessageInformation.class, getPartyMessageInformation());
		processRosetta(path.newSubPath("signature"), processor, SignatureType.class, getSignature());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ResponseMessageHeaderBuilder extends ResponseMessageHeader, MessageHeader.MessageHeaderBuilder {
		MessageId.MessageIdBuilder getOrCreateInReplyTo();
		@Override
		MessageId.MessageIdBuilder getInReplyTo();
		MessageAddress.MessageAddressBuilder getOrCreateSentBy();
		@Override
		MessageAddress.MessageAddressBuilder getSentBy();
		MessageAddress.MessageAddressBuilder getOrCreateSendTo(int index);
		@Override
		List<? extends MessageAddress.MessageAddressBuilder> getSendTo();
		MessageAddress.MessageAddressBuilder getOrCreateCopyTo(int index);
		@Override
		List<? extends MessageAddress.MessageAddressBuilder> getCopyTo();
		ImplementationSpecification.ImplementationSpecificationBuilder getOrCreateImplementationSpecification();
		@Override
		ImplementationSpecification.ImplementationSpecificationBuilder getImplementationSpecification();
		PartyMessageInformation.PartyMessageInformationBuilder getOrCreatePartyMessageInformation(int index);
		@Override
		List<? extends PartyMessageInformation.PartyMessageInformationBuilder> getPartyMessageInformation();
		SignatureType.SignatureTypeBuilder getOrCreateSignature(int index);
		@Override
		List<? extends SignatureType.SignatureTypeBuilder> getSignature();
		@Override
		ResponseMessageHeader.ResponseMessageHeaderBuilder setMessageId(MessageId messageId);
		ResponseMessageHeader.ResponseMessageHeaderBuilder setInReplyTo(MessageId inReplyTo);
		ResponseMessageHeader.ResponseMessageHeaderBuilder setSentBy(MessageAddress sentBy);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addSendTo(MessageAddress sendTo);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addSendTo(MessageAddress sendTo, int idx);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addSendTo(List<? extends MessageAddress> sendTo);
		ResponseMessageHeader.ResponseMessageHeaderBuilder setSendTo(List<? extends MessageAddress> sendTo);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addCopyTo(MessageAddress copyTo);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addCopyTo(MessageAddress copyTo, int idx);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addCopyTo(List<? extends MessageAddress> copyTo);
		ResponseMessageHeader.ResponseMessageHeaderBuilder setCopyTo(List<? extends MessageAddress> copyTo);
		ResponseMessageHeader.ResponseMessageHeaderBuilder setCreationTimestamp(ZonedDateTime creationTimestamp);
		ResponseMessageHeader.ResponseMessageHeaderBuilder setExpiryTimestamp(ZonedDateTime expiryTimestamp);
		ResponseMessageHeader.ResponseMessageHeaderBuilder setImplementationSpecification(ImplementationSpecification implementationSpecification);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addPartyMessageInformation(PartyMessageInformation partyMessageInformation);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addPartyMessageInformation(PartyMessageInformation partyMessageInformation, int idx);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformation);
		ResponseMessageHeader.ResponseMessageHeaderBuilder setPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformation);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addSignature(SignatureType signature);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addSignature(SignatureType signature, int idx);
		ResponseMessageHeader.ResponseMessageHeaderBuilder addSignature(List<? extends SignatureType> signature);
		ResponseMessageHeader.ResponseMessageHeaderBuilder setSignature(List<? extends SignatureType> signature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("messageId"), processor, MessageId.MessageIdBuilder.class, getMessageId());
			processRosetta(path.newSubPath("inReplyTo"), processor, MessageId.MessageIdBuilder.class, getInReplyTo());
			processRosetta(path.newSubPath("sentBy"), processor, MessageAddress.MessageAddressBuilder.class, getSentBy());
			processRosetta(path.newSubPath("sendTo"), processor, MessageAddress.MessageAddressBuilder.class, getSendTo());
			processRosetta(path.newSubPath("copyTo"), processor, MessageAddress.MessageAddressBuilder.class, getCopyTo());
			processor.processBasic(path.newSubPath("creationTimestamp"), ZonedDateTime.class, getCreationTimestamp(), this);
			processor.processBasic(path.newSubPath("expiryTimestamp"), ZonedDateTime.class, getExpiryTimestamp(), this);
			processRosetta(path.newSubPath("implementationSpecification"), processor, ImplementationSpecification.ImplementationSpecificationBuilder.class, getImplementationSpecification());
			processRosetta(path.newSubPath("partyMessageInformation"), processor, PartyMessageInformation.PartyMessageInformationBuilder.class, getPartyMessageInformation());
			processRosetta(path.newSubPath("signature"), processor, SignatureType.SignatureTypeBuilder.class, getSignature());
		}
		

		ResponseMessageHeader.ResponseMessageHeaderBuilder prune();
	}

	/*********************** Immutable Implementation of ResponseMessageHeader  ***********************/
	class ResponseMessageHeaderImpl extends MessageHeader.MessageHeaderImpl implements ResponseMessageHeader {
		private final MessageId inReplyTo;
		private final MessageAddress sentBy;
		private final List<? extends MessageAddress> sendTo;
		private final List<? extends MessageAddress> copyTo;
		private final ZonedDateTime creationTimestamp;
		private final ZonedDateTime expiryTimestamp;
		private final ImplementationSpecification implementationSpecification;
		private final List<? extends PartyMessageInformation> partyMessageInformation;
		private final List<? extends SignatureType> signature;
		
		protected ResponseMessageHeaderImpl(ResponseMessageHeader.ResponseMessageHeaderBuilder builder) {
			super(builder);
			this.inReplyTo = ofNullable(builder.getInReplyTo()).map(f->f.build()).orElse(null);
			this.sentBy = ofNullable(builder.getSentBy()).map(f->f.build()).orElse(null);
			this.sendTo = ofNullable(builder.getSendTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.copyTo = ofNullable(builder.getCopyTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.creationTimestamp = builder.getCreationTimestamp();
			this.expiryTimestamp = builder.getExpiryTimestamp();
			this.implementationSpecification = ofNullable(builder.getImplementationSpecification()).map(f->f.build()).orElse(null);
			this.partyMessageInformation = ofNullable(builder.getPartyMessageInformation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.signature = ofNullable(builder.getSignature()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("inReplyTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inReplyTo")
		public MessageId getInReplyTo() {
			return inReplyTo;
		}
		
		@Override
		@RosettaAttribute("sentBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sentBy")
		public MessageAddress getSentBy() {
			return sentBy;
		}
		
		@Override
		@RosettaAttribute("sendTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sendTo")
		public List<? extends MessageAddress> getSendTo() {
			return sendTo;
		}
		
		@Override
		@RosettaAttribute("copyTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("copyTo")
		public List<? extends MessageAddress> getCopyTo() {
			return copyTo;
		}
		
		@Override
		@RosettaAttribute("creationTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creationTimestamp")
		public ZonedDateTime getCreationTimestamp() {
			return creationTimestamp;
		}
		
		@Override
		@RosettaAttribute("expiryTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryTimestamp")
		public ZonedDateTime getExpiryTimestamp() {
			return expiryTimestamp;
		}
		
		@Override
		@RosettaAttribute("implementationSpecification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("implementationSpecification")
		public ImplementationSpecification getImplementationSpecification() {
			return implementationSpecification;
		}
		
		@Override
		@RosettaAttribute("partyMessageInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyMessageInformation")
		public List<? extends PartyMessageInformation> getPartyMessageInformation() {
			return partyMessageInformation;
		}
		
		@Override
		@RosettaAttribute("signature")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("signature")
		public List<? extends SignatureType> getSignature() {
			return signature;
		}
		
		@Override
		public ResponseMessageHeader build() {
			return this;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder toBuilder() {
			ResponseMessageHeader.ResponseMessageHeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResponseMessageHeader.ResponseMessageHeaderBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInReplyTo()).ifPresent(builder::setInReplyTo);
			ofNullable(getSentBy()).ifPresent(builder::setSentBy);
			ofNullable(getSendTo()).ifPresent(builder::setSendTo);
			ofNullable(getCopyTo()).ifPresent(builder::setCopyTo);
			ofNullable(getCreationTimestamp()).ifPresent(builder::setCreationTimestamp);
			ofNullable(getExpiryTimestamp()).ifPresent(builder::setExpiryTimestamp);
			ofNullable(getImplementationSpecification()).ifPresent(builder::setImplementationSpecification);
			ofNullable(getPartyMessageInformation()).ifPresent(builder::setPartyMessageInformation);
			ofNullable(getSignature()).ifPresent(builder::setSignature);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResponseMessageHeader _that = getType().cast(o);
		
			if (!Objects.equals(inReplyTo, _that.getInReplyTo())) return false;
			if (!Objects.equals(sentBy, _that.getSentBy())) return false;
			if (!ListEquals.listEquals(sendTo, _that.getSendTo())) return false;
			if (!ListEquals.listEquals(copyTo, _that.getCopyTo())) return false;
			if (!Objects.equals(creationTimestamp, _that.getCreationTimestamp())) return false;
			if (!Objects.equals(expiryTimestamp, _that.getExpiryTimestamp())) return false;
			if (!Objects.equals(implementationSpecification, _that.getImplementationSpecification())) return false;
			if (!ListEquals.listEquals(partyMessageInformation, _that.getPartyMessageInformation())) return false;
			if (!ListEquals.listEquals(signature, _that.getSignature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inReplyTo != null ? inReplyTo.hashCode() : 0);
			_result = 31 * _result + (sentBy != null ? sentBy.hashCode() : 0);
			_result = 31 * _result + (sendTo != null ? sendTo.hashCode() : 0);
			_result = 31 * _result + (copyTo != null ? copyTo.hashCode() : 0);
			_result = 31 * _result + (creationTimestamp != null ? creationTimestamp.hashCode() : 0);
			_result = 31 * _result + (expiryTimestamp != null ? expiryTimestamp.hashCode() : 0);
			_result = 31 * _result + (implementationSpecification != null ? implementationSpecification.hashCode() : 0);
			_result = 31 * _result + (partyMessageInformation != null ? partyMessageInformation.hashCode() : 0);
			_result = 31 * _result + (signature != null ? signature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResponseMessageHeader {" +
				"inReplyTo=" + this.inReplyTo + ", " +
				"sentBy=" + this.sentBy + ", " +
				"sendTo=" + this.sendTo + ", " +
				"copyTo=" + this.copyTo + ", " +
				"creationTimestamp=" + this.creationTimestamp + ", " +
				"expiryTimestamp=" + this.expiryTimestamp + ", " +
				"implementationSpecification=" + this.implementationSpecification + ", " +
				"partyMessageInformation=" + this.partyMessageInformation + ", " +
				"signature=" + this.signature +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ResponseMessageHeader  ***********************/
	class ResponseMessageHeaderBuilderImpl extends MessageHeader.MessageHeaderBuilderImpl implements ResponseMessageHeader.ResponseMessageHeaderBuilder {
	
		protected MessageId.MessageIdBuilder inReplyTo;
		protected MessageAddress.MessageAddressBuilder sentBy;
		protected List<MessageAddress.MessageAddressBuilder> sendTo = new ArrayList<>();
		protected List<MessageAddress.MessageAddressBuilder> copyTo = new ArrayList<>();
		protected ZonedDateTime creationTimestamp;
		protected ZonedDateTime expiryTimestamp;
		protected ImplementationSpecification.ImplementationSpecificationBuilder implementationSpecification;
		protected List<PartyMessageInformation.PartyMessageInformationBuilder> partyMessageInformation = new ArrayList<>();
		protected List<SignatureType.SignatureTypeBuilder> signature = new ArrayList<>();
		
		@Override
		@RosettaAttribute("inReplyTo")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("inReplyTo")
		public MessageId.MessageIdBuilder getInReplyTo() {
			return inReplyTo;
		}
		
		@Override
		public MessageId.MessageIdBuilder getOrCreateInReplyTo() {
			MessageId.MessageIdBuilder result;
			if (inReplyTo!=null) {
				result = inReplyTo;
			}
			else {
				result = inReplyTo = MessageId.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sentBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sentBy")
		public MessageAddress.MessageAddressBuilder getSentBy() {
			return sentBy;
		}
		
		@Override
		public MessageAddress.MessageAddressBuilder getOrCreateSentBy() {
			MessageAddress.MessageAddressBuilder result;
			if (sentBy!=null) {
				result = sentBy;
			}
			else {
				result = sentBy = MessageAddress.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sendTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sendTo")
		public List<? extends MessageAddress.MessageAddressBuilder> getSendTo() {
			return sendTo;
		}
		
		@Override
		public MessageAddress.MessageAddressBuilder getOrCreateSendTo(int index) {
			if (sendTo==null) {
				this.sendTo = new ArrayList<>();
			}
			return getIndex(sendTo, index, () -> {
						MessageAddress.MessageAddressBuilder newSendTo = MessageAddress.builder();
						return newSendTo;
					});
		}
		
		@Override
		@RosettaAttribute("copyTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("copyTo")
		public List<? extends MessageAddress.MessageAddressBuilder> getCopyTo() {
			return copyTo;
		}
		
		@Override
		public MessageAddress.MessageAddressBuilder getOrCreateCopyTo(int index) {
			if (copyTo==null) {
				this.copyTo = new ArrayList<>();
			}
			return getIndex(copyTo, index, () -> {
						MessageAddress.MessageAddressBuilder newCopyTo = MessageAddress.builder();
						return newCopyTo;
					});
		}
		
		@Override
		@RosettaAttribute("creationTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("creationTimestamp")
		public ZonedDateTime getCreationTimestamp() {
			return creationTimestamp;
		}
		
		@Override
		@RosettaAttribute("expiryTimestamp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("expiryTimestamp")
		public ZonedDateTime getExpiryTimestamp() {
			return expiryTimestamp;
		}
		
		@Override
		@RosettaAttribute("implementationSpecification")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("implementationSpecification")
		public ImplementationSpecification.ImplementationSpecificationBuilder getImplementationSpecification() {
			return implementationSpecification;
		}
		
		@Override
		public ImplementationSpecification.ImplementationSpecificationBuilder getOrCreateImplementationSpecification() {
			ImplementationSpecification.ImplementationSpecificationBuilder result;
			if (implementationSpecification!=null) {
				result = implementationSpecification;
			}
			else {
				result = implementationSpecification = ImplementationSpecification.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("partyMessageInformation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("partyMessageInformation")
		public List<? extends PartyMessageInformation.PartyMessageInformationBuilder> getPartyMessageInformation() {
			return partyMessageInformation;
		}
		
		@Override
		public PartyMessageInformation.PartyMessageInformationBuilder getOrCreatePartyMessageInformation(int index) {
			if (partyMessageInformation==null) {
				this.partyMessageInformation = new ArrayList<>();
			}
			return getIndex(partyMessageInformation, index, () -> {
						PartyMessageInformation.PartyMessageInformationBuilder newPartyMessageInformation = PartyMessageInformation.builder();
						return newPartyMessageInformation;
					});
		}
		
		@Override
		@RosettaAttribute("signature")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("signature")
		public List<? extends SignatureType.SignatureTypeBuilder> getSignature() {
			return signature;
		}
		
		@Override
		public SignatureType.SignatureTypeBuilder getOrCreateSignature(int index) {
			if (signature==null) {
				this.signature = new ArrayList<>();
			}
			return getIndex(signature, index, () -> {
						SignatureType.SignatureTypeBuilder newSignature = SignatureType.builder();
						return newSignature;
					});
		}
		
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageId")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setMessageId(MessageId _messageId) {
			this.messageId = _messageId == null ? null : _messageId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("inReplyTo")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("inReplyTo")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setInReplyTo(MessageId _inReplyTo) {
			this.inReplyTo = _inReplyTo == null ? null : _inReplyTo.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sentBy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sentBy")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setSentBy(MessageAddress _sentBy) {
			this.sentBy = _sentBy == null ? null : _sentBy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sendTo")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("sendTo")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addSendTo(MessageAddress _sendTo) {
			if (_sendTo != null) {
				this.sendTo.add(_sendTo.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addSendTo(MessageAddress _sendTo, int idx) {
			getIndex(this.sendTo, idx, () -> _sendTo.toBuilder());
			return this;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addSendTo(List<? extends MessageAddress> sendTos) {
			if (sendTos != null) {
				for (final MessageAddress toAdd : sendTos) {
					this.sendTo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("sendTo")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("sendTo")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setSendTo(List<? extends MessageAddress> sendTos) {
			if (sendTos == null) {
				this.sendTo = new ArrayList<>();
			} else {
				this.sendTo = sendTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("copyTo")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("copyTo")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addCopyTo(MessageAddress _copyTo) {
			if (_copyTo != null) {
				this.copyTo.add(_copyTo.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addCopyTo(MessageAddress _copyTo, int idx) {
			getIndex(this.copyTo, idx, () -> _copyTo.toBuilder());
			return this;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addCopyTo(List<? extends MessageAddress> copyTos) {
			if (copyTos != null) {
				for (final MessageAddress toAdd : copyTos) {
					this.copyTo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("copyTo")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("copyTo")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setCopyTo(List<? extends MessageAddress> copyTos) {
			if (copyTos == null) {
				this.copyTo = new ArrayList<>();
			} else {
				this.copyTo = copyTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("creationTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("creationTimestamp")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setCreationTimestamp(ZonedDateTime _creationTimestamp) {
			this.creationTimestamp = _creationTimestamp == null ? null : _creationTimestamp;
			return this;
		}
		
		@RosettaAttribute("expiryTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryTimestamp")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setExpiryTimestamp(ZonedDateTime _expiryTimestamp) {
			this.expiryTimestamp = _expiryTimestamp == null ? null : _expiryTimestamp;
			return this;
		}
		
		@RosettaAttribute("implementationSpecification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("implementationSpecification")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setImplementationSpecification(ImplementationSpecification _implementationSpecification) {
			this.implementationSpecification = _implementationSpecification == null ? null : _implementationSpecification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyMessageInformation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyMessageInformation")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addPartyMessageInformation(PartyMessageInformation _partyMessageInformation) {
			if (_partyMessageInformation != null) {
				this.partyMessageInformation.add(_partyMessageInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addPartyMessageInformation(PartyMessageInformation _partyMessageInformation, int idx) {
			getIndex(this.partyMessageInformation, idx, () -> _partyMessageInformation.toBuilder());
			return this;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformations) {
			if (partyMessageInformations != null) {
				for (final PartyMessageInformation toAdd : partyMessageInformations) {
					this.partyMessageInformation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("partyMessageInformation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("partyMessageInformation")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformations) {
			if (partyMessageInformations == null) {
				this.partyMessageInformation = new ArrayList<>();
			} else {
				this.partyMessageInformation = partyMessageInformations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("signature")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("signature")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addSignature(SignatureType _signature) {
			if (_signature != null) {
				this.signature.add(_signature.toBuilder());
			}
			return this;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addSignature(SignatureType _signature, int idx) {
			getIndex(this.signature, idx, () -> _signature.toBuilder());
			return this;
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder addSignature(List<? extends SignatureType> signatures) {
			if (signatures != null) {
				for (final SignatureType toAdd : signatures) {
					this.signature.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("signature")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("signature")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder setSignature(List<? extends SignatureType> signatures) {
			if (signatures == null) {
				this.signature = new ArrayList<>();
			} else {
				this.signature = signatures.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public ResponseMessageHeader build() {
			return new ResponseMessageHeader.ResponseMessageHeaderImpl(this);
		}
		
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder prune() {
			super.prune();
			if (inReplyTo!=null && !inReplyTo.prune().hasData()) inReplyTo = null;
			if (sentBy!=null && !sentBy.prune().hasData()) sentBy = null;
			sendTo = sendTo.stream().filter(b->b!=null).<MessageAddress.MessageAddressBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			copyTo = copyTo.stream().filter(b->b!=null).<MessageAddress.MessageAddressBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (implementationSpecification!=null && !implementationSpecification.prune().hasData()) implementationSpecification = null;
			partyMessageInformation = partyMessageInformation.stream().filter(b->b!=null).<PartyMessageInformation.PartyMessageInformationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			signature = signature.stream().filter(b->b!=null).<SignatureType.SignatureTypeBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInReplyTo()!=null && getInReplyTo().hasData()) return true;
			if (getSentBy()!=null && getSentBy().hasData()) return true;
			if (getSendTo()!=null && getSendTo().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCopyTo()!=null && getCopyTo().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getCreationTimestamp()!=null) return true;
			if (getExpiryTimestamp()!=null) return true;
			if (getImplementationSpecification()!=null && getImplementationSpecification().hasData()) return true;
			if (getPartyMessageInformation()!=null && getPartyMessageInformation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getSignature()!=null && getSignature().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResponseMessageHeader.ResponseMessageHeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ResponseMessageHeader.ResponseMessageHeaderBuilder o = (ResponseMessageHeader.ResponseMessageHeaderBuilder) other;
			
			merger.mergeRosetta(getInReplyTo(), o.getInReplyTo(), this::setInReplyTo);
			merger.mergeRosetta(getSentBy(), o.getSentBy(), this::setSentBy);
			merger.mergeRosetta(getSendTo(), o.getSendTo(), this::getOrCreateSendTo);
			merger.mergeRosetta(getCopyTo(), o.getCopyTo(), this::getOrCreateCopyTo);
			merger.mergeRosetta(getImplementationSpecification(), o.getImplementationSpecification(), this::setImplementationSpecification);
			merger.mergeRosetta(getPartyMessageInformation(), o.getPartyMessageInformation(), this::getOrCreatePartyMessageInformation);
			merger.mergeRosetta(getSignature(), o.getSignature(), this::getOrCreateSignature);
			
			merger.mergeBasic(getCreationTimestamp(), o.getCreationTimestamp(), this::setCreationTimestamp);
			merger.mergeBasic(getExpiryTimestamp(), o.getExpiryTimestamp(), this::setExpiryTimestamp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ResponseMessageHeader _that = getType().cast(o);
		
			if (!Objects.equals(inReplyTo, _that.getInReplyTo())) return false;
			if (!Objects.equals(sentBy, _that.getSentBy())) return false;
			if (!ListEquals.listEquals(sendTo, _that.getSendTo())) return false;
			if (!ListEquals.listEquals(copyTo, _that.getCopyTo())) return false;
			if (!Objects.equals(creationTimestamp, _that.getCreationTimestamp())) return false;
			if (!Objects.equals(expiryTimestamp, _that.getExpiryTimestamp())) return false;
			if (!Objects.equals(implementationSpecification, _that.getImplementationSpecification())) return false;
			if (!ListEquals.listEquals(partyMessageInformation, _that.getPartyMessageInformation())) return false;
			if (!ListEquals.listEquals(signature, _that.getSignature())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (inReplyTo != null ? inReplyTo.hashCode() : 0);
			_result = 31 * _result + (sentBy != null ? sentBy.hashCode() : 0);
			_result = 31 * _result + (sendTo != null ? sendTo.hashCode() : 0);
			_result = 31 * _result + (copyTo != null ? copyTo.hashCode() : 0);
			_result = 31 * _result + (creationTimestamp != null ? creationTimestamp.hashCode() : 0);
			_result = 31 * _result + (expiryTimestamp != null ? expiryTimestamp.hashCode() : 0);
			_result = 31 * _result + (implementationSpecification != null ? implementationSpecification.hashCode() : 0);
			_result = 31 * _result + (partyMessageInformation != null ? partyMessageInformation.hashCode() : 0);
			_result = 31 * _result + (signature != null ? signature.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResponseMessageHeaderBuilder {" +
				"inReplyTo=" + this.inReplyTo + ", " +
				"sentBy=" + this.sentBy + ", " +
				"sendTo=" + this.sendTo + ", " +
				"copyTo=" + this.copyTo + ", " +
				"creationTimestamp=" + this.creationTimestamp + ", " +
				"expiryTimestamp=" + this.expiryTimestamp + ", " +
				"implementationSpecification=" + this.implementationSpecification + ", " +
				"partyMessageInformation=" + this.partyMessageInformation + ", " +
				"signature=" + this.signature +
			'}' + " " + super.toString();
		}
	}
}
