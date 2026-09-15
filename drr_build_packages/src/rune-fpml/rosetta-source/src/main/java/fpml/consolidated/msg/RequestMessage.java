package fpml.consolidated.msg;

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
import com.rosetta.util.ListEquals;
import fpml.consolidated.doc.Validation;
import fpml.consolidated.msg.meta.RequestMessageMeta;
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
 * Provision A type defining the basic content of a message that requests the receiver to perform some business operation determined by the message type and its content.
 *
 *
 * Body ISDA
 * Corpus Schema FPML FPML  
 * version "confirmation-5.13"
 *
 * Provision A type defining the basic content of a message that requests the receiver to perform some business operation determined by the message type and its content.
 *
 */
@RosettaDataType(value="RequestMessage", builder=RequestMessage.RequestMessageBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RequestMessage", model="fpml", builder=RequestMessage.RequestMessageBuilderImpl.class, version="2.1.1")
public interface RequestMessage extends Message {

	RequestMessageMeta metaData = new RequestMessageMeta();

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
	RequestMessageHeader getHeader();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision A list of validation sets the sender asserts the document is valid with respect to.
	 *
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "confirmation-5.13"
	 *
	 * Provision A list of validation sets the sender asserts the document is valid with respect to.
	 *
	 */
	List<? extends Validation> getValidation();

	/*********************** Build Methods  ***********************/
	RequestMessage build();
	
	RequestMessage.RequestMessageBuilder toBuilder();
	
	static RequestMessage.RequestMessageBuilder builder() {
		return new RequestMessage.RequestMessageBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RequestMessage> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RequestMessage> getType() {
		return RequestMessage.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("validation"), processor, Validation.class, getValidation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RequestMessageBuilder extends RequestMessage, Message.MessageBuilder {
		RequestMessageHeader.RequestMessageHeaderBuilder getOrCreateHeader();
		@Override
		RequestMessageHeader.RequestMessageHeaderBuilder getHeader();
		Validation.ValidationBuilder getOrCreateValidation(int index);
		@Override
		List<? extends Validation.ValidationBuilder> getValidation();
		@Override
		RequestMessage.RequestMessageBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RequestMessage.RequestMessageBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RequestMessage.RequestMessageBuilder setActualBuild(Integer actualBuild);
		RequestMessage.RequestMessageBuilder setHeader(RequestMessageHeader header);
		RequestMessage.RequestMessageBuilder addValidation(Validation validation);
		RequestMessage.RequestMessageBuilder addValidation(Validation validation, int idx);
		RequestMessage.RequestMessageBuilder addValidation(List<? extends Validation> validation);
		RequestMessage.RequestMessageBuilder setValidation(List<? extends Validation> validation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, RequestMessageHeader.RequestMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("validation"), processor, Validation.ValidationBuilder.class, getValidation());
		}
		

		RequestMessage.RequestMessageBuilder prune();
	}

	/*********************** Immutable Implementation of RequestMessage  ***********************/
	class RequestMessageImpl extends Message.MessageImpl implements RequestMessage {
		private final RequestMessageHeader header;
		private final List<? extends Validation> validation;
		
		protected RequestMessageImpl(RequestMessage.RequestMessageBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.validation = ofNullable(builder.getValidation()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public RequestMessageHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("validation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("validation")
		public List<? extends Validation> getValidation() {
			return validation;
		}
		
		@Override
		public RequestMessage build() {
			return this;
		}
		
		@Override
		public RequestMessage.RequestMessageBuilder toBuilder() {
			RequestMessage.RequestMessageBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RequestMessage.RequestMessageBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getValidation()).ifPresent(builder::setValidation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestMessage {" +
				"header=" + this.header + ", " +
				"validation=" + this.validation +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RequestMessage  ***********************/
	class RequestMessageBuilderImpl extends Message.MessageBuilderImpl implements RequestMessage.RequestMessageBuilder {
	
		protected RequestMessageHeader.RequestMessageHeaderBuilder header;
		protected List<Validation.ValidationBuilder> validation = new ArrayList<>();
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public RequestMessageHeader.RequestMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public RequestMessageHeader.RequestMessageHeaderBuilder getOrCreateHeader() {
			RequestMessageHeader.RequestMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = RequestMessageHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("validation")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("validation")
		public List<? extends Validation.ValidationBuilder> getValidation() {
			return validation;
		}
		
		@Override
		public Validation.ValidationBuilder getOrCreateValidation(int index) {
			if (validation==null) {
				this.validation = new ArrayList<>();
			}
			return getIndex(validation, index, () -> {
						Validation.ValidationBuilder newValidation = Validation.builder();
						return newValidation;
					});
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public RequestMessage.RequestMessageBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RequestMessage.RequestMessageBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RequestMessage.RequestMessageBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RequestMessage.RequestMessageBuilder setHeader(RequestMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestMessage.RequestMessageBuilder addValidation(Validation _validation) {
			if (_validation != null) {
				this.validation.add(_validation.toBuilder());
			}
			return this;
		}
		
		@Override
		public RequestMessage.RequestMessageBuilder addValidation(Validation _validation, int idx) {
			getIndex(this.validation, idx, () -> _validation.toBuilder());
			return this;
		}
		
		@Override
		public RequestMessage.RequestMessageBuilder addValidation(List<? extends Validation> validations) {
			if (validations != null) {
				for (final Validation toAdd : validations) {
					this.validation.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("validation")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("validation")
		@Override
		public RequestMessage.RequestMessageBuilder setValidation(List<? extends Validation> validations) {
			if (validations == null) {
				this.validation = new ArrayList<>();
			} else {
				this.validation = validations.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RequestMessage build() {
			return new RequestMessage.RequestMessageImpl(this);
		}
		
		@Override
		public RequestMessage.RequestMessageBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestMessage.RequestMessageBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			validation = validation.stream().filter(b->b!=null).<Validation.ValidationBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getValidation()!=null && getValidation().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RequestMessage.RequestMessageBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RequestMessage.RequestMessageBuilder o = (RequestMessage.RequestMessageBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getValidation(), o.getValidation(), this::getOrCreateValidation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RequestMessage _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(validation, _that.getValidation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (validation != null ? validation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RequestMessageBuilder {" +
				"header=" + this.header + ", " +
				"validation=" + this.validation +
			'}' + " " + super.toString();
		}
	}
}
