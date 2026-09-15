package fpml.consolidated.msg;

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
import fpml.consolidated.msg.meta.MessageHeaderMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the content model for a generic message header that is refined by its derived classes.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the content model for a generic message header that is refined by its derived classes.
 *
 */
@RosettaDataType(value="MessageHeader", builder=MessageHeader.MessageHeaderBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MessageHeader", model="fpml", builder=MessageHeader.MessageHeaderBuilderImpl.class, version="2.1.1")
public interface MessageHeader extends RosettaModelObject {

	MessageHeaderMeta metaData = new MessageHeaderMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A unique identifier (within its coding scheme) assigned to the message by its creating party.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A unique identifier (within its coding scheme) assigned to the message by its creating party.
	 *
	 */
	MessageId getMessageId();

	/*********************** Build Methods  ***********************/
	MessageHeader build();
	
	MessageHeader.MessageHeaderBuilder toBuilder();
	
	static MessageHeader.MessageHeaderBuilder builder() {
		return new MessageHeader.MessageHeaderBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MessageHeader> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MessageHeader> getType() {
		return MessageHeader.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("messageId"), processor, MessageId.class, getMessageId());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MessageHeaderBuilder extends MessageHeader, RosettaModelObjectBuilder {
		MessageId.MessageIdBuilder getOrCreateMessageId();
		@Override
		MessageId.MessageIdBuilder getMessageId();
		MessageHeader.MessageHeaderBuilder setMessageId(MessageId messageId);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("messageId"), processor, MessageId.MessageIdBuilder.class, getMessageId());
		}
		

		MessageHeader.MessageHeaderBuilder prune();
	}

	/*********************** Immutable Implementation of MessageHeader  ***********************/
	class MessageHeaderImpl implements MessageHeader {
		private final MessageId messageId;
		
		protected MessageHeaderImpl(MessageHeader.MessageHeaderBuilder builder) {
			this.messageId = ofNullable(builder.getMessageId()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageId")
		public MessageId getMessageId() {
			return messageId;
		}
		
		@Override
		public MessageHeader build() {
			return this;
		}
		
		@Override
		public MessageHeader.MessageHeaderBuilder toBuilder() {
			MessageHeader.MessageHeaderBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageHeader.MessageHeaderBuilder builder) {
			ofNullable(getMessageId()).ifPresent(builder::setMessageId);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageHeader _that = getType().cast(o);
		
			if (!Objects.equals(messageId, _that.getMessageId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (messageId != null ? messageId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageHeader {" +
				"messageId=" + this.messageId +
			'}';
		}
	}

	/*********************** Builder Implementation of MessageHeader  ***********************/
	class MessageHeaderBuilderImpl implements MessageHeader.MessageHeaderBuilder {
	
		protected MessageId.MessageIdBuilder messageId;
		
		@Override
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageId")
		public MessageId.MessageIdBuilder getMessageId() {
			return messageId;
		}
		
		@Override
		public MessageId.MessageIdBuilder getOrCreateMessageId() {
			MessageId.MessageIdBuilder result;
			if (messageId!=null) {
				result = messageId;
			}
			else {
				result = messageId = MessageId.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageId")
		@Override
		public MessageHeader.MessageHeaderBuilder setMessageId(MessageId _messageId) {
			this.messageId = _messageId == null ? null : _messageId.toBuilder();
			return this;
		}
		
		@Override
		public MessageHeader build() {
			return new MessageHeader.MessageHeaderImpl(this);
		}
		
		@Override
		public MessageHeader.MessageHeaderBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageHeader.MessageHeaderBuilder prune() {
			if (messageId!=null && !messageId.prune().hasData()) messageId = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMessageId()!=null && getMessageId().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageHeader.MessageHeaderBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MessageHeader.MessageHeaderBuilder o = (MessageHeader.MessageHeaderBuilder) other;
			
			merger.mergeRosetta(getMessageId(), o.getMessageId(), this::setMessageId);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageHeader _that = getType().cast(o);
		
			if (!Objects.equals(messageId, _that.getMessageId())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (messageId != null ? messageId.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageHeaderBuilder {" +
				"messageId=" + this.messageId +
			'}';
		}
	}
}
