package fpml.consolidated.msg;

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
import fpml.consolidated.msg.meta.MessageIdMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type use for message identifiers.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type use for message identifiers.
 *
 */
@RosettaDataType(value="MessageId", builder=MessageId.MessageIdBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MessageId", model="fpml", builder=MessageId.MessageIdBuilderImpl.class, version="2.1.1")
public interface MessageId extends RosettaModelObject {

	MessageIdMeta metaData = new MessageIdMeta();

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
	String getMessageIdScheme();

	/*********************** Build Methods  ***********************/
	MessageId build();
	
	MessageId.MessageIdBuilder toBuilder();
	
	static MessageId.MessageIdBuilder builder() {
		return new MessageId.MessageIdBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MessageId> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MessageId> getType() {
		return MessageId.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("messageIdScheme"), String.class, getMessageIdScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MessageIdBuilder extends MessageId, RosettaModelObjectBuilder {
		MessageId.MessageIdBuilder setValue(String value);
		MessageId.MessageIdBuilder setMessageIdScheme(String messageIdScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("messageIdScheme"), String.class, getMessageIdScheme(), this);
		}
		

		MessageId.MessageIdBuilder prune();
	}

	/*********************** Immutable Implementation of MessageId  ***********************/
	class MessageIdImpl implements MessageId {
		private final String value;
		private final String messageIdScheme;
		
		protected MessageIdImpl(MessageId.MessageIdBuilder builder) {
			this.value = builder.getValue();
			this.messageIdScheme = builder.getMessageIdScheme();
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
		@RosettaAttribute("messageIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageIdScheme")
		public String getMessageIdScheme() {
			return messageIdScheme;
		}
		
		@Override
		public MessageId build() {
			return this;
		}
		
		@Override
		public MessageId.MessageIdBuilder toBuilder() {
			MessageId.MessageIdBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageId.MessageIdBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMessageIdScheme()).ifPresent(builder::setMessageIdScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(messageIdScheme, _that.getMessageIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (messageIdScheme != null ? messageIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageId {" +
				"value=" + this.value + ", " +
				"messageIdScheme=" + this.messageIdScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MessageId  ***********************/
	class MessageIdBuilderImpl implements MessageId.MessageIdBuilder {
	
		protected String value;
		protected String messageIdScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("messageIdScheme")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageIdScheme")
		public String getMessageIdScheme() {
			return messageIdScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MessageId.MessageIdBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("messageIdScheme")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("messageIdScheme")
		@Override
		public MessageId.MessageIdBuilder setMessageIdScheme(String _messageIdScheme) {
			this.messageIdScheme = _messageIdScheme == null ? null : _messageIdScheme;
			return this;
		}
		
		@Override
		public MessageId build() {
			return new MessageId.MessageIdImpl(this);
		}
		
		@Override
		public MessageId.MessageIdBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageId.MessageIdBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMessageIdScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageId.MessageIdBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MessageId.MessageIdBuilder o = (MessageId.MessageIdBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMessageIdScheme(), o.getMessageIdScheme(), this::setMessageIdScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageId _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(messageIdScheme, _that.getMessageIdScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (messageIdScheme != null ? messageIdScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageIdBuilder {" +
				"value=" + this.value + ", " +
				"messageIdScheme=" + this.messageIdScheme +
			'}';
		}
	}
}
