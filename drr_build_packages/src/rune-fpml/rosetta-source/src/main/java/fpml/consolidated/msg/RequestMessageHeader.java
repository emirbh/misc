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
import fpml.consolidated.msg.meta.RequestMessageHeaderMeta;
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
 * Provision A type refining the generic message header content to make it specific to request messages.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type refining the generic message header content to make it specific to request messages.
 *
 */
@RosettaDataType(value="RequestMessageHeader", builder=RequestMessageHeader.RequestMessageHeaderBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestMessageHeader", model="fpml", builder=RequestMessageHeader.RequestMessageHeaderBuilderImpl.class, version="2.1.1")
public interface RequestMessageHeader extends MessageHeader {

	RequestMessageHeaderMeta metaData = new RequestMessageHeaderMeta();

	/*********************** Getter Methods  ***********************/
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
	RequestMessageHeader build();
	
	RequestMessageHeader.RequestMessageHeaderBuilder toBuilder();
	
	static RequestMessageHeader.RequestMessageHeaderBuilder builder() {
		return new RequestMessageHeader.RequestMessageHeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestMessageHeader> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestMessageHeader> getType() {
		return RequestMessageHeader.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("messageId"), processor, MessageId.class, getMessageId());
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
	interface RequestMessageHeaderBuilder extends RequestMessageHeader, MessageHeader.MessageHeaderBuilder {
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
		RequestMessageHeader.RequestMessageHeaderBuilder setMessageId(MessageId messageId);
		RequestMessageHeader.RequestMessageHeaderBuilder setSentBy(MessageAddress sentBy);
		RequestMessageHeader.RequestMessageHeaderBuilder addSendTo(MessageAddress sendTo);
		RequestMessageHeader.RequestMessageHeaderBuilder addSendTo(MessageAddress sendTo, int idx);
		RequestMessageHeader.RequestMessageHeaderBuilder addSendTo(List<? extends MessageAddress> sendTo);
		RequestMessageHeader.RequestMessageHeaderBuilder setSendTo(List<? extends MessageAddress> sendTo);
		RequestMessageHeader.RequestMessageHeaderBuilder addCopyTo(MessageAddress copyTo);
		RequestMessageHeader.RequestMessageHeaderBuilder addCopyTo(MessageAddress copyTo, int idx);
		RequestMessageHeader.RequestMessageHeaderBuilder addCopyTo(List<? extends MessageAddress> copyTo);
		RequestMessageHeader.RequestMessageHeaderBuilder setCopyTo(List<? extends MessageAddress> copyTo);
		RequestMessageHeader.RequestMessageHeaderBuilder setCreationTimestamp(ZonedDateTime creationTimestamp);
		RequestMessageHeader.RequestMessageHeaderBuilder setExpiryTimestamp(ZonedDateTime expiryTimestamp);
		RequestMessageHeader.RequestMessageHeaderBuilder setImplementationSpecification(ImplementationSpecification implementationSpecification);
		RequestMessageHeader.RequestMessageHeaderBuilder addPartyMessageInformation(PartyMessageInformation partyMessageInformation);
		RequestMessageHeader.RequestMessageHeaderBuilder addPartyMessageInformation(PartyMessageInformation partyMessageInformation, int idx);
		RequestMessageHeader.RequestMessageHeaderBuilder addPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformation);
		RequestMessageHeader.RequestMessageHeaderBuilder setPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformation);
		RequestMessageHeader.RequestMessageHeaderBuilder addSignature(SignatureType signature);
		RequestMessageHeader.RequestMessageHeaderBuilder addSignature(SignatureType signature, int idx);
		RequestMessageHeader.RequestMessageHeaderBuilder addSignature(List<? extends SignatureType> signature);
		RequestMessageHeader.RequestMessageHeaderBuilder setSignature(List<? extends SignatureType> signature);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("messageId"), processor, MessageId.MessageIdBuilder.class, getMessageId());
			processRosetta(path.newSubPath("sentBy"), processor, MessageAddress.MessageAddressBuilder.class, getSentBy());
			processRosetta(path.newSubPath("sendTo"), processor, MessageAddress.MessageAddressBuilder.class, getSendTo());
			processRosetta(path.newSubPath("copyTo"), processor, MessageAddress.MessageAddressBuilder.class, getCopyTo());
			processor.processBasic(path.newSubPath("creationTimestamp"), ZonedDateTime.class, getCreationTimestamp(), this);
			processor.processBasic(path.newSubPath("expiryTimestamp"), ZonedDateTime.class, getExpiryTimestamp(), this);
			processRosetta(path.newSubPath("implementationSpecification"), processor, ImplementationSpecification.ImplementationSpecificationBuilder.class, getImplementationSpecification());
			processRosetta(path.newSubPath("partyMessageInformation"), processor, PartyMessageInformation.PartyMessageInformationBuilder.class, getPartyMessageInformation());
			processRosetta(path.newSubPath("signature"), processor, SignatureType.SignatureTypeBuilder.class, getSignature());
		}
		

		RequestMessageHeader.RequestMessageHeaderBuilder prune();
	}

	/*********************** Immutable Implementation of RequestMessageHeader  ***********************/
	class RequestMessageHeaderImpl extends MessageHeader.MessageHeaderImpl implements RequestMessageHeader {
		private final MessageAddress sentBy;
		private final List<? extends MessageAddress> sendTo;
		private final List<? extends MessageAddress> copyTo;
		private final ZonedDateTime creationTimestamp;
		private final ZonedDateTime expiryTimestamp;
		private final ImplementationSpecification implementationSpecification;
		private final List<? extends PartyMessageInformation> partyMessageInformation;
		private final List<? extends SignatureType> signature;
		
		protected RequestMessageHeaderImpl(RequestMessageHeader.RequestMessageHeaderBuilder builder) {
			super(builder);
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
		public RequestMessageHeader build() {
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder toBuilder() {
			RequestMessageHeader.RequestMessageHeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestMessageHeader.RequestMessageHeaderBuilder builder) {
			super.setBuilderFields(builder);
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
		
			RequestMessageHeader _that = getType().cast(o);
		
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
			return "RequestMessageHeader {" +
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

	/*********************** Builder Implementation of RequestMessageHeader  ***********************/
	class RequestMessageHeaderBuilderImpl extends MessageHeader.MessageHeaderBuilderImpl implements RequestMessageHeader.RequestMessageHeaderBuilder {
	
		protected MessageAddress.MessageAddressBuilder sentBy;
		protected List<MessageAddress.MessageAddressBuilder> sendTo = new ArrayList<>();
		protected List<MessageAddress.MessageAddressBuilder> copyTo = new ArrayList<>();
		protected ZonedDateTime creationTimestamp;
		protected ZonedDateTime expiryTimestamp;
		protected ImplementationSpecification.ImplementationSpecificationBuilder implementationSpecification;
		protected List<PartyMessageInformation.PartyMessageInformationBuilder> partyMessageInformation = new ArrayList<>();
		protected List<SignatureType.SignatureTypeBuilder> signature = new ArrayList<>();
		
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
		public RequestMessageHeader.RequestMessageHeaderBuilder setMessageId(MessageId _messageId) {
			this.messageId = _messageId == null ? null : _messageId.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sentBy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sentBy")
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder setSentBy(MessageAddress _sentBy) {
			this.sentBy = _sentBy == null ? null : _sentBy.toBuilder();
			return this;
		}
		
		@RosettaAttribute("sendTo")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("sendTo")
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addSendTo(MessageAddress _sendTo) {
			if (_sendTo != null) {
				this.sendTo.add(_sendTo.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addSendTo(MessageAddress _sendTo, int idx) {
			getIndex(this.sendTo, idx, () -> _sendTo.toBuilder());
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addSendTo(List<? extends MessageAddress> sendTos) {
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
		public RequestMessageHeader.RequestMessageHeaderBuilder setSendTo(List<? extends MessageAddress> sendTos) {
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
		public RequestMessageHeader.RequestMessageHeaderBuilder addCopyTo(MessageAddress _copyTo) {
			if (_copyTo != null) {
				this.copyTo.add(_copyTo.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addCopyTo(MessageAddress _copyTo, int idx) {
			getIndex(this.copyTo, idx, () -> _copyTo.toBuilder());
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addCopyTo(List<? extends MessageAddress> copyTos) {
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
		public RequestMessageHeader.RequestMessageHeaderBuilder setCopyTo(List<? extends MessageAddress> copyTos) {
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
		public RequestMessageHeader.RequestMessageHeaderBuilder setCreationTimestamp(ZonedDateTime _creationTimestamp) {
			this.creationTimestamp = _creationTimestamp == null ? null : _creationTimestamp;
			return this;
		}
		
		@RosettaAttribute("expiryTimestamp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expiryTimestamp")
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder setExpiryTimestamp(ZonedDateTime _expiryTimestamp) {
			this.expiryTimestamp = _expiryTimestamp == null ? null : _expiryTimestamp;
			return this;
		}
		
		@RosettaAttribute("implementationSpecification")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("implementationSpecification")
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder setImplementationSpecification(ImplementationSpecification _implementationSpecification) {
			this.implementationSpecification = _implementationSpecification == null ? null : _implementationSpecification.toBuilder();
			return this;
		}
		
		@RosettaAttribute("partyMessageInformation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("partyMessageInformation")
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addPartyMessageInformation(PartyMessageInformation _partyMessageInformation) {
			if (_partyMessageInformation != null) {
				this.partyMessageInformation.add(_partyMessageInformation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addPartyMessageInformation(PartyMessageInformation _partyMessageInformation, int idx) {
			getIndex(this.partyMessageInformation, idx, () -> _partyMessageInformation.toBuilder());
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformations) {
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
		public RequestMessageHeader.RequestMessageHeaderBuilder setPartyMessageInformation(List<? extends PartyMessageInformation> partyMessageInformations) {
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
		public RequestMessageHeader.RequestMessageHeaderBuilder addSignature(SignatureType _signature) {
			if (_signature != null) {
				this.signature.add(_signature.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addSignature(SignatureType _signature, int idx) {
			getIndex(this.signature, idx, () -> _signature.toBuilder());
			return this;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder addSignature(List<? extends SignatureType> signatures) {
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
		public RequestMessageHeader.RequestMessageHeaderBuilder setSignature(List<? extends SignatureType> signatures) {
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
		public RequestMessageHeader build() {
			return new RequestMessageHeader.RequestMessageHeaderImpl(this);
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder prune() {
			super.prune();
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
		public RequestMessageHeader.RequestMessageHeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestMessageHeader.RequestMessageHeaderBuilder o = (RequestMessageHeader.RequestMessageHeaderBuilder) other;
			
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
		
			RequestMessageHeader _that = getType().cast(o);
		
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
			return "RequestMessageHeaderBuilder {" +
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
