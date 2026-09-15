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
import fpml.consolidated.msg.meta.MessageAddressMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision The data type used for identifying a message address.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision The data type used for identifying a message address.
 *
 */
@RosettaDataType(value="MessageAddress", builder=MessageAddress.MessageAddressBuilderImpl.class, version="2.1.1")
@RuneDataType(value="MessageAddress", model="fpml", builder=MessageAddress.MessageAddressBuilderImpl.class, version="2.1.1")
public interface MessageAddress extends RosettaModelObject {

	MessageAddressMeta metaData = new MessageAddressMeta();

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
	String getMessageAddressScheme();

	/*********************** Build Methods  ***********************/
	MessageAddress build();
	
	MessageAddress.MessageAddressBuilder toBuilder();
	
	static MessageAddress.MessageAddressBuilder builder() {
		return new MessageAddress.MessageAddressBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MessageAddress> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MessageAddress> getType() {
		return MessageAddress.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
		processor.processBasic(path.newSubPath("messageAddressScheme"), String.class, getMessageAddressScheme(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MessageAddressBuilder extends MessageAddress, RosettaModelObjectBuilder {
		MessageAddress.MessageAddressBuilder setValue(String value);
		MessageAddress.MessageAddressBuilder setMessageAddressScheme(String messageAddressScheme);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("value"), String.class, getValue(), this);
			processor.processBasic(path.newSubPath("messageAddressScheme"), String.class, getMessageAddressScheme(), this);
		}
		

		MessageAddress.MessageAddressBuilder prune();
	}

	/*********************** Immutable Implementation of MessageAddress  ***********************/
	class MessageAddressImpl implements MessageAddress {
		private final String value;
		private final String messageAddressScheme;
		
		protected MessageAddressImpl(MessageAddress.MessageAddressBuilder builder) {
			this.value = builder.getValue();
			this.messageAddressScheme = builder.getMessageAddressScheme();
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
		@RosettaAttribute("messageAddressScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageAddressScheme")
		public String getMessageAddressScheme() {
			return messageAddressScheme;
		}
		
		@Override
		public MessageAddress build() {
			return this;
		}
		
		@Override
		public MessageAddress.MessageAddressBuilder toBuilder() {
			MessageAddress.MessageAddressBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageAddress.MessageAddressBuilder builder) {
			ofNullable(getValue()).ifPresent(builder::setValue);
			ofNullable(getMessageAddressScheme()).ifPresent(builder::setMessageAddressScheme);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageAddress _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(messageAddressScheme, _that.getMessageAddressScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (messageAddressScheme != null ? messageAddressScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageAddress {" +
				"value=" + this.value + ", " +
				"messageAddressScheme=" + this.messageAddressScheme +
			'}';
		}
	}

	/*********************** Builder Implementation of MessageAddress  ***********************/
	class MessageAddressBuilderImpl implements MessageAddress.MessageAddressBuilder {
	
		protected String value;
		protected String messageAddressScheme;
		
		@Override
		@RosettaAttribute("value")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("value")
		public String getValue() {
			return value;
		}
		
		@Override
		@RosettaAttribute("messageAddressScheme")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("messageAddressScheme")
		public String getMessageAddressScheme() {
			return messageAddressScheme;
		}
		
		@RosettaAttribute("value")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("value")
		@Override
		public MessageAddress.MessageAddressBuilder setValue(String _value) {
			this.value = _value == null ? null : _value;
			return this;
		}
		
		@RosettaAttribute("messageAddressScheme")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("messageAddressScheme")
		@Override
		public MessageAddress.MessageAddressBuilder setMessageAddressScheme(String _messageAddressScheme) {
			this.messageAddressScheme = _messageAddressScheme == null ? null : _messageAddressScheme;
			return this;
		}
		
		@Override
		public MessageAddress build() {
			return new MessageAddress.MessageAddressImpl(this);
		}
		
		@Override
		public MessageAddress.MessageAddressBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageAddress.MessageAddressBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValue()!=null) return true;
			if (getMessageAddressScheme()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageAddress.MessageAddressBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MessageAddress.MessageAddressBuilder o = (MessageAddress.MessageAddressBuilder) other;
			
			
			merger.mergeBasic(getValue(), o.getValue(), this::setValue);
			merger.mergeBasic(getMessageAddressScheme(), o.getMessageAddressScheme(), this::setMessageAddressScheme);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageAddress _that = getType().cast(o);
		
			if (!Objects.equals(value, _that.getValue())) return false;
			if (!Objects.equals(messageAddressScheme, _that.getMessageAddressScheme())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			_result = 31 * _result + (messageAddressScheme != null ? messageAddressScheme.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageAddressBuilder {" +
				"value=" + this.value + ", " +
				"messageAddressScheme=" + this.messageAddressScheme +
			'}';
		}
	}
}
