package cdm.event.workflow;

import cdm.event.workflow.meta.MessageInformationMeta;
import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
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
import com.rosetta.model.metafields.FieldWithMetaString;
import com.rosetta.util.ListEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * This class corresponds to the components of the FpML MessageHeader.model.
 * @version 6.23.0
 */
@RosettaDataType(value="MessageInformation", builder=MessageInformation.MessageInformationBuilderImpl.class, version="6.23.0")
@RuneDataType(value="MessageInformation", model="cdm", builder=MessageInformation.MessageInformationBuilderImpl.class, version="6.23.0")
public interface MessageInformation extends RosettaModelObject {

	MessageInformationMeta metaData = new MessageInformationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A unique identifier assigned to the message.
	 */
	FieldWithMetaString getMessageId();
	/**
	 * The identifier for the originator of a message instance.
	 */
	FieldWithMetaString getSentBy();
	/**
	 * The identifier(s) for the recipient(s) of a message instance.
	 */
	List<? extends FieldWithMetaString> getSentTo();
	/**
	 * A unique identifier (within the specified coding scheme) giving the details of some party to whom a copy of this message will be sent for reference.
	 */
	List<? extends FieldWithMetaString> getCopyTo();

	/*********************** Build Methods  ***********************/
	MessageInformation build();
	
	MessageInformation.MessageInformationBuilder toBuilder();
	
	static MessageInformation.MessageInformationBuilder builder() {
		return new MessageInformation.MessageInformationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MessageInformation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MessageInformation> getType() {
		return MessageInformation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("messageId"), processor, FieldWithMetaString.class, getMessageId());
		processRosetta(path.newSubPath("sentBy"), processor, FieldWithMetaString.class, getSentBy());
		processRosetta(path.newSubPath("sentTo"), processor, FieldWithMetaString.class, getSentTo());
		processRosetta(path.newSubPath("copyTo"), processor, FieldWithMetaString.class, getCopyTo());
	}
	

	/*********************** Builder Interface  ***********************/
	interface MessageInformationBuilder extends MessageInformation, RosettaModelObjectBuilder {
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateMessageId();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getMessageId();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateSentBy();
		@Override
		FieldWithMetaString.FieldWithMetaStringBuilder getSentBy();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateSentTo(int index);
		@Override
		List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getSentTo();
		FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCopyTo(int index);
		@Override
		List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getCopyTo();
		MessageInformation.MessageInformationBuilder setMessageId(FieldWithMetaString messageId);
		MessageInformation.MessageInformationBuilder setMessageIdValue(String messageId);
		MessageInformation.MessageInformationBuilder setSentBy(FieldWithMetaString sentBy);
		MessageInformation.MessageInformationBuilder setSentByValue(String sentBy);
		MessageInformation.MessageInformationBuilder addSentTo(FieldWithMetaString sentTo);
		MessageInformation.MessageInformationBuilder addSentTo(FieldWithMetaString sentTo, int idx);
		MessageInformation.MessageInformationBuilder addSentToValue(String sentTo);
		MessageInformation.MessageInformationBuilder addSentToValue(String sentTo, int idx);
		MessageInformation.MessageInformationBuilder addSentTo(List<? extends FieldWithMetaString> sentTo);
		MessageInformation.MessageInformationBuilder setSentTo(List<? extends FieldWithMetaString> sentTo);
		MessageInformation.MessageInformationBuilder addSentToValue(List<? extends String> sentTo);
		MessageInformation.MessageInformationBuilder setSentToValue(List<? extends String> sentTo);
		MessageInformation.MessageInformationBuilder addCopyTo(FieldWithMetaString copyTo);
		MessageInformation.MessageInformationBuilder addCopyTo(FieldWithMetaString copyTo, int idx);
		MessageInformation.MessageInformationBuilder addCopyToValue(String copyTo);
		MessageInformation.MessageInformationBuilder addCopyToValue(String copyTo, int idx);
		MessageInformation.MessageInformationBuilder addCopyTo(List<? extends FieldWithMetaString> copyTo);
		MessageInformation.MessageInformationBuilder setCopyTo(List<? extends FieldWithMetaString> copyTo);
		MessageInformation.MessageInformationBuilder addCopyToValue(List<? extends String> copyTo);
		MessageInformation.MessageInformationBuilder setCopyToValue(List<? extends String> copyTo);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("messageId"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getMessageId());
			processRosetta(path.newSubPath("sentBy"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getSentBy());
			processRosetta(path.newSubPath("sentTo"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getSentTo());
			processRosetta(path.newSubPath("copyTo"), processor, FieldWithMetaString.FieldWithMetaStringBuilder.class, getCopyTo());
		}
		

		MessageInformation.MessageInformationBuilder prune();
	}

	/*********************** Immutable Implementation of MessageInformation  ***********************/
	class MessageInformationImpl implements MessageInformation {
		private final FieldWithMetaString messageId;
		private final FieldWithMetaString sentBy;
		private final List<? extends FieldWithMetaString> sentTo;
		private final List<? extends FieldWithMetaString> copyTo;
		
		protected MessageInformationImpl(MessageInformation.MessageInformationBuilder builder) {
			this.messageId = ofNullable(builder.getMessageId()).map(f->f.build()).orElse(null);
			this.sentBy = ofNullable(builder.getSentBy()).map(f->f.build()).orElse(null);
			this.sentTo = ofNullable(builder.getSentTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.copyTo = ofNullable(builder.getCopyTo()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageId")
		public FieldWithMetaString getMessageId() {
			return messageId;
		}
		
		@Override
		@RosettaAttribute("sentBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sentBy")
		public FieldWithMetaString getSentBy() {
			return sentBy;
		}
		
		@Override
		@RosettaAttribute("sentTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sentTo")
		public List<? extends FieldWithMetaString> getSentTo() {
			return sentTo;
		}
		
		@Override
		@RosettaAttribute("copyTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("copyTo")
		public List<? extends FieldWithMetaString> getCopyTo() {
			return copyTo;
		}
		
		@Override
		public MessageInformation build() {
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder toBuilder() {
			MessageInformation.MessageInformationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MessageInformation.MessageInformationBuilder builder) {
			ofNullable(getMessageId()).ifPresent(builder::setMessageId);
			ofNullable(getSentBy()).ifPresent(builder::setSentBy);
			ofNullable(getSentTo()).ifPresent(builder::setSentTo);
			ofNullable(getCopyTo()).ifPresent(builder::setCopyTo);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageInformation _that = getType().cast(o);
		
			if (!Objects.equals(messageId, _that.getMessageId())) return false;
			if (!Objects.equals(sentBy, _that.getSentBy())) return false;
			if (!ListEquals.listEquals(sentTo, _that.getSentTo())) return false;
			if (!ListEquals.listEquals(copyTo, _that.getCopyTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (messageId != null ? messageId.hashCode() : 0);
			_result = 31 * _result + (sentBy != null ? sentBy.hashCode() : 0);
			_result = 31 * _result + (sentTo != null ? sentTo.hashCode() : 0);
			_result = 31 * _result + (copyTo != null ? copyTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageInformation {" +
				"messageId=" + this.messageId + ", " +
				"sentBy=" + this.sentBy + ", " +
				"sentTo=" + this.sentTo + ", " +
				"copyTo=" + this.copyTo +
			'}';
		}
	}

	/*********************** Builder Implementation of MessageInformation  ***********************/
	class MessageInformationBuilderImpl implements MessageInformation.MessageInformationBuilder {
	
		protected FieldWithMetaString.FieldWithMetaStringBuilder messageId;
		protected FieldWithMetaString.FieldWithMetaStringBuilder sentBy;
		protected List<FieldWithMetaString.FieldWithMetaStringBuilder> sentTo = new ArrayList<>();
		protected List<FieldWithMetaString.FieldWithMetaStringBuilder> copyTo = new ArrayList<>();
		
		@Override
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("messageId")
		public FieldWithMetaString.FieldWithMetaStringBuilder getMessageId() {
			return messageId;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateMessageId() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (messageId!=null) {
				result = messageId;
			}
			else {
				result = messageId = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sentBy")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sentBy")
		public FieldWithMetaString.FieldWithMetaStringBuilder getSentBy() {
			return sentBy;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateSentBy() {
			FieldWithMetaString.FieldWithMetaStringBuilder result;
			if (sentBy!=null) {
				result = sentBy;
			}
			else {
				result = sentBy = FieldWithMetaString.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("sentTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("sentTo")
		public List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getSentTo() {
			return sentTo;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateSentTo(int index) {
			if (sentTo==null) {
				this.sentTo = new ArrayList<>();
			}
			return getIndex(sentTo, index, () -> {
						FieldWithMetaString.FieldWithMetaStringBuilder newSentTo = FieldWithMetaString.builder();
						return newSentTo;
					});
		}
		
		@Override
		@RosettaAttribute("copyTo")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("copyTo")
		public List<? extends FieldWithMetaString.FieldWithMetaStringBuilder> getCopyTo() {
			return copyTo;
		}
		
		@Override
		public FieldWithMetaString.FieldWithMetaStringBuilder getOrCreateCopyTo(int index) {
			if (copyTo==null) {
				this.copyTo = new ArrayList<>();
			}
			return getIndex(copyTo, index, () -> {
						FieldWithMetaString.FieldWithMetaStringBuilder newCopyTo = FieldWithMetaString.builder();
						return newCopyTo;
					});
		}
		
		@RosettaAttribute("messageId")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("messageId")
		@Override
		public MessageInformation.MessageInformationBuilder setMessageId(FieldWithMetaString _messageId) {
			this.messageId = _messageId == null ? null : _messageId.toBuilder();
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder setMessageIdValue(String _messageId) {
			this.getOrCreateMessageId().setValue(_messageId);
			return this;
		}
		
		@RosettaAttribute("sentBy")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sentBy")
		@Override
		public MessageInformation.MessageInformationBuilder setSentBy(FieldWithMetaString _sentBy) {
			this.sentBy = _sentBy == null ? null : _sentBy.toBuilder();
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder setSentByValue(String _sentBy) {
			this.getOrCreateSentBy().setValue(_sentBy);
			return this;
		}
		
		@RosettaAttribute("sentTo")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("sentTo")
		@Override
		public MessageInformation.MessageInformationBuilder addSentTo(FieldWithMetaString _sentTo) {
			if (_sentTo != null) {
				this.sentTo.add(_sentTo.toBuilder());
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addSentTo(FieldWithMetaString _sentTo, int idx) {
			getIndex(this.sentTo, idx, () -> _sentTo.toBuilder());
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addSentToValue(String _sentTo) {
			this.getOrCreateSentTo(-1).setValue(_sentTo);
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addSentToValue(String _sentTo, int idx) {
			this.getOrCreateSentTo(idx).setValue(_sentTo);
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addSentTo(List<? extends FieldWithMetaString> sentTos) {
			if (sentTos != null) {
				for (final FieldWithMetaString toAdd : sentTos) {
					this.sentTo.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("sentTo")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("sentTo")
		@Override
		public MessageInformation.MessageInformationBuilder setSentTo(List<? extends FieldWithMetaString> sentTos) {
			if (sentTos == null) {
				this.sentTo = new ArrayList<>();
			} else {
				this.sentTo = sentTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addSentToValue(List<? extends String> sentTos) {
			if (sentTos != null) {
				for (final String toAdd : sentTos) {
					this.addSentToValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder setSentToValue(List<? extends String> sentTos) {
			this.sentTo.clear();
			if (sentTos != null) {
				sentTos.forEach(this::addSentToValue);
			}
			return this;
		}
		
		@RosettaAttribute("copyTo")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("copyTo")
		@Override
		public MessageInformation.MessageInformationBuilder addCopyTo(FieldWithMetaString _copyTo) {
			if (_copyTo != null) {
				this.copyTo.add(_copyTo.toBuilder());
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addCopyTo(FieldWithMetaString _copyTo, int idx) {
			getIndex(this.copyTo, idx, () -> _copyTo.toBuilder());
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addCopyToValue(String _copyTo) {
			this.getOrCreateCopyTo(-1).setValue(_copyTo);
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addCopyToValue(String _copyTo, int idx) {
			this.getOrCreateCopyTo(idx).setValue(_copyTo);
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addCopyTo(List<? extends FieldWithMetaString> copyTos) {
			if (copyTos != null) {
				for (final FieldWithMetaString toAdd : copyTos) {
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
		public MessageInformation.MessageInformationBuilder setCopyTo(List<? extends FieldWithMetaString> copyTos) {
			if (copyTos == null) {
				this.copyTo = new ArrayList<>();
			} else {
				this.copyTo = copyTos.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder addCopyToValue(List<? extends String> copyTos) {
			if (copyTos != null) {
				for (final String toAdd : copyTos) {
					this.addCopyToValue(toAdd);
				}
			}
			return this;
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder setCopyToValue(List<? extends String> copyTos) {
			this.copyTo.clear();
			if (copyTos != null) {
				copyTos.forEach(this::addCopyToValue);
			}
			return this;
		}
		
		@Override
		public MessageInformation build() {
			return new MessageInformation.MessageInformationImpl(this);
		}
		
		@Override
		public MessageInformation.MessageInformationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageInformation.MessageInformationBuilder prune() {
			if (messageId!=null && !messageId.prune().hasData()) messageId = null;
			if (sentBy!=null && !sentBy.prune().hasData()) sentBy = null;
			sentTo = sentTo.stream().filter(b->b!=null).<FieldWithMetaString.FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			copyTo = copyTo.stream().filter(b->b!=null).<FieldWithMetaString.FieldWithMetaStringBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getMessageId()!=null) return true;
			if (getSentBy()!=null) return true;
			if (getSentTo()!=null && !getSentTo().isEmpty()) return true;
			if (getCopyTo()!=null && !getCopyTo().isEmpty()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MessageInformation.MessageInformationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MessageInformation.MessageInformationBuilder o = (MessageInformation.MessageInformationBuilder) other;
			
			merger.mergeRosetta(getMessageId(), o.getMessageId(), this::setMessageId);
			merger.mergeRosetta(getSentBy(), o.getSentBy(), this::setSentBy);
			merger.mergeRosetta(getSentTo(), o.getSentTo(), this::getOrCreateSentTo);
			merger.mergeRosetta(getCopyTo(), o.getCopyTo(), this::getOrCreateCopyTo);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MessageInformation _that = getType().cast(o);
		
			if (!Objects.equals(messageId, _that.getMessageId())) return false;
			if (!Objects.equals(sentBy, _that.getSentBy())) return false;
			if (!ListEquals.listEquals(sentTo, _that.getSentTo())) return false;
			if (!ListEquals.listEquals(copyTo, _that.getCopyTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (messageId != null ? messageId.hashCode() : 0);
			_result = 31 * _result + (sentBy != null ? sentBy.hashCode() : 0);
			_result = 31 * _result + (sentTo != null ? sentTo.hashCode() : 0);
			_result = 31 * _result + (copyTo != null ? copyTo.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MessageInformationBuilder {" +
				"messageId=" + this.messageId + ", " +
				"sentBy=" + this.sentBy + ", " +
				"sentTo=" + this.sentTo + ", " +
				"copyTo=" + this.copyTo +
			'}';
		}
	}
}
