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
import fpml.consolidated.msg.meta.AddressedMessageMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 2.1.1
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "recordkeeping-5.13"
 *
 * Provision A type defining the basic content for a message sent to inform another system that some exception has been detected.
 *
 */
@RosettaDataType(value="AddressedMessage", builder=AddressedMessage.AddressedMessageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="AddressedMessage", model="fpml", builder=AddressedMessage.AddressedMessageBuilderImpl.class, version="2.1.1")
public interface AddressedMessage extends Message {

	AddressedMessageMeta metaData = new AddressedMessageMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision 
	 *
	 */
	NotificationMessageHeader getHeader();

	/*********************** Build Methods  ***********************/
	AddressedMessage build();
	
	AddressedMessage.AddressedMessageBuilder toBuilder();
	
	static AddressedMessage.AddressedMessageBuilder builder() {
		return new AddressedMessage.AddressedMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AddressedMessage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AddressedMessage> getType() {
		return AddressedMessage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.class, getHeader());
	}
	

	/*********************** Builder Interface  ***********************/
	interface AddressedMessageBuilder extends AddressedMessage, Message.MessageBuilder {
		NotificationMessageHeader.NotificationMessageHeaderBuilder getOrCreateHeader();
		@Override
		NotificationMessageHeader.NotificationMessageHeaderBuilder getHeader();
		@Override
		AddressedMessage.AddressedMessageBuilder setFpmlVersion(String fpmlVersion);
		@Override
		AddressedMessage.AddressedMessageBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		AddressedMessage.AddressedMessageBuilder setActualBuild(Integer actualBuild);
		AddressedMessage.AddressedMessageBuilder setHeader(NotificationMessageHeader header);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, NotificationMessageHeader.NotificationMessageHeaderBuilder.class, getHeader());
		}
		

		AddressedMessage.AddressedMessageBuilder prune();
	}

	/*********************** Immutable Implementation of AddressedMessage  ***********************/
	class AddressedMessageImpl extends Message.MessageImpl implements AddressedMessage {
		private final NotificationMessageHeader header;
		
		protected AddressedMessageImpl(AddressedMessage.AddressedMessageBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public NotificationMessageHeader getHeader() {
			return header;
		}
		
		@Override
		public AddressedMessage build() {
			return this;
		}
		
		@Override
		public AddressedMessage.AddressedMessageBuilder toBuilder() {
			AddressedMessage.AddressedMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AddressedMessage.AddressedMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AddressedMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AddressedMessage {" +
				"header=" + this.header +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of AddressedMessage  ***********************/
	class AddressedMessageBuilderImpl extends Message.MessageBuilderImpl implements AddressedMessage.AddressedMessageBuilder {
	
		protected NotificationMessageHeader.NotificationMessageHeaderBuilder header;
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public NotificationMessageHeader.NotificationMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public NotificationMessageHeader.NotificationMessageHeaderBuilder getOrCreateHeader() {
			NotificationMessageHeader.NotificationMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = NotificationMessageHeader.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public AddressedMessage.AddressedMessageBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public AddressedMessage.AddressedMessageBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public AddressedMessage.AddressedMessageBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public AddressedMessage.AddressedMessageBuilder setHeader(NotificationMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@Override
		public AddressedMessage build() {
			return new AddressedMessage.AddressedMessageImpl(this);
		}
		
		@Override
		public AddressedMessage.AddressedMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AddressedMessage.AddressedMessageBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AddressedMessage.AddressedMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			AddressedMessage.AddressedMessageBuilder o = (AddressedMessage.AddressedMessageBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			AddressedMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AddressedMessageBuilder {" +
				"header=" + this.header +
			'}' + " " + super.toString();
		}
	}
}
