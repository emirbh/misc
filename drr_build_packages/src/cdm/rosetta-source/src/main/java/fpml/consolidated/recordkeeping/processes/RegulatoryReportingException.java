package fpml.consolidated.recordkeeping.processes;

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
import fpml.consolidated.doc.AdditionalData;
import fpml.consolidated.doc.Reason;
import fpml.consolidated.msg.ExceptionMessageHeader;
import fpml.consolidated.msg.Message;
import fpml.consolidated.recordkeeping.processes.meta.RegulatoryReportingExceptionMeta;
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
 * Provision A type defining the basic content for a message sent to inform another system that some exception has been detected in a regulatory reporting message.
 *
 */
@RosettaDataType(value="RegulatoryReportingException", builder=RegulatoryReportingException.RegulatoryReportingExceptionBuilderImpl.class, version="2.1.1")
@RuneDataType(value="RegulatoryReportingException", model="fpml", builder=RegulatoryReportingException.RegulatoryReportingExceptionBuilderImpl.class, version="2.1.1")
public interface RegulatoryReportingException extends Message {

	RegulatoryReportingExceptionMeta metaData = new RegulatoryReportingExceptionMeta();

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
	ExceptionMessageHeader getHeader();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision An instance of the Reason type used to record the nature of any errors associated with a message.
	 *
	 */
	List<? extends Reason> getReason();
	/**
	 *
	 * Body ISDA
	 * Corpus Schema FPML FPML  
	 * version "recordkeeping-5.13"
	 *
	 * Provision Any string of additional data that may help the message processor, for example in a rejection message this might contain a code value or the text of the original request (within a CDATA section).
	 *
	 */
	AdditionalData getAdditionalData();

	/*********************** Build Methods  ***********************/
	RegulatoryReportingException build();
	
	RegulatoryReportingException.RegulatoryReportingExceptionBuilder toBuilder();
	
	static RegulatoryReportingException.RegulatoryReportingExceptionBuilder builder() {
		return new RegulatoryReportingException.RegulatoryReportingExceptionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegulatoryReportingException> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegulatoryReportingException> getType() {
		return RegulatoryReportingException.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
		processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
		processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
		processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.class, getHeader());
		processRosetta(path.newSubPath("reason"), processor, Reason.class, getReason());
		processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.class, getAdditionalData());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegulatoryReportingExceptionBuilder extends RegulatoryReportingException, Message.MessageBuilder {
		ExceptionMessageHeader.ExceptionMessageHeaderBuilder getOrCreateHeader();
		@Override
		ExceptionMessageHeader.ExceptionMessageHeaderBuilder getHeader();
		Reason.ReasonBuilder getOrCreateReason(int index);
		@Override
		List<? extends Reason.ReasonBuilder> getReason();
		AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData();
		@Override
		AdditionalData.AdditionalDataBuilder getAdditionalData();
		@Override
		RegulatoryReportingException.RegulatoryReportingExceptionBuilder setFpmlVersion(String fpmlVersion);
		@Override
		RegulatoryReportingException.RegulatoryReportingExceptionBuilder setExpectedBuild(Integer expectedBuild);
		@Override
		RegulatoryReportingException.RegulatoryReportingExceptionBuilder setActualBuild(Integer actualBuild);
		RegulatoryReportingException.RegulatoryReportingExceptionBuilder setHeader(ExceptionMessageHeader header);
		RegulatoryReportingException.RegulatoryReportingExceptionBuilder addReason(Reason reason);
		RegulatoryReportingException.RegulatoryReportingExceptionBuilder addReason(Reason reason, int idx);
		RegulatoryReportingException.RegulatoryReportingExceptionBuilder addReason(List<? extends Reason> reason);
		RegulatoryReportingException.RegulatoryReportingExceptionBuilder setReason(List<? extends Reason> reason);
		RegulatoryReportingException.RegulatoryReportingExceptionBuilder setAdditionalData(AdditionalData additionalData);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("fpmlVersion"), String.class, getFpmlVersion(), this);
			processor.processBasic(path.newSubPath("expectedBuild"), Integer.class, getExpectedBuild(), this);
			processor.processBasic(path.newSubPath("actualBuild"), Integer.class, getActualBuild(), this);
			processRosetta(path.newSubPath("header"), processor, ExceptionMessageHeader.ExceptionMessageHeaderBuilder.class, getHeader());
			processRosetta(path.newSubPath("reason"), processor, Reason.ReasonBuilder.class, getReason());
			processRosetta(path.newSubPath("additionalData"), processor, AdditionalData.AdditionalDataBuilder.class, getAdditionalData());
		}
		

		RegulatoryReportingException.RegulatoryReportingExceptionBuilder prune();
	}

	/*********************** Immutable Implementation of RegulatoryReportingException  ***********************/
	class RegulatoryReportingExceptionImpl extends Message.MessageImpl implements RegulatoryReportingException {
		private final ExceptionMessageHeader header;
		private final List<? extends Reason> reason;
		private final AdditionalData additionalData;
		
		protected RegulatoryReportingExceptionImpl(RegulatoryReportingException.RegulatoryReportingExceptionBuilder builder) {
			super(builder);
			this.header = ofNullable(builder.getHeader()).map(f->f.build()).orElse(null);
			this.reason = ofNullable(builder.getReason()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.additionalData = ofNullable(builder.getAdditionalData()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public ExceptionMessageHeader getHeader() {
			return header;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason> getReason() {
			return reason;
		}
		
		@Override
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalData")
		public AdditionalData getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public RegulatoryReportingException build() {
			return this;
		}
		
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder toBuilder() {
			RegulatoryReportingException.RegulatoryReportingExceptionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegulatoryReportingException.RegulatoryReportingExceptionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getHeader()).ifPresent(builder::setHeader);
			ofNullable(getReason()).ifPresent(builder::setReason);
			ofNullable(getAdditionalData()).ifPresent(builder::setAdditionalData);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryReportingException _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingException {" +
				"header=" + this.header + ", " +
				"reason=" + this.reason + ", " +
				"additionalData=" + this.additionalData +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegulatoryReportingException  ***********************/
	class RegulatoryReportingExceptionBuilderImpl extends Message.MessageBuilderImpl implements RegulatoryReportingException.RegulatoryReportingExceptionBuilder {
	
		protected ExceptionMessageHeader.ExceptionMessageHeaderBuilder header;
		protected List<Reason.ReasonBuilder> reason = new ArrayList<>();
		protected AdditionalData.AdditionalDataBuilder additionalData;
		
		@Override
		@RosettaAttribute("header")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("header")
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder getHeader() {
			return header;
		}
		
		@Override
		public ExceptionMessageHeader.ExceptionMessageHeaderBuilder getOrCreateHeader() {
			ExceptionMessageHeader.ExceptionMessageHeaderBuilder result;
			if (header!=null) {
				result = header;
			}
			else {
				result = header = ExceptionMessageHeader.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reason")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("reason")
		public List<? extends Reason.ReasonBuilder> getReason() {
			return reason;
		}
		
		@Override
		public Reason.ReasonBuilder getOrCreateReason(int index) {
			if (reason==null) {
				this.reason = new ArrayList<>();
			}
			return getIndex(reason, index, () -> {
						Reason.ReasonBuilder newReason = Reason.builder();
						return newReason;
					});
		}
		
		@Override
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("additionalData")
		public AdditionalData.AdditionalDataBuilder getAdditionalData() {
			return additionalData;
		}
		
		@Override
		public AdditionalData.AdditionalDataBuilder getOrCreateAdditionalData() {
			AdditionalData.AdditionalDataBuilder result;
			if (additionalData!=null) {
				result = additionalData;
			}
			else {
				result = additionalData = AdditionalData.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("fpmlVersion")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("fpmlVersion")
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder setFpmlVersion(String _fpmlVersion) {
			this.fpmlVersion = _fpmlVersion == null ? null : _fpmlVersion;
			return this;
		}
		
		@RosettaAttribute("expectedBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("expectedBuild")
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder setExpectedBuild(Integer _expectedBuild) {
			this.expectedBuild = _expectedBuild == null ? null : _expectedBuild;
			return this;
		}
		
		@RosettaAttribute("actualBuild")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("actualBuild")
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder setActualBuild(Integer _actualBuild) {
			this.actualBuild = _actualBuild == null ? null : _actualBuild;
			return this;
		}
		
		@RosettaAttribute("header")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("header")
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder setHeader(ExceptionMessageHeader _header) {
			this.header = _header == null ? null : _header.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder addReason(Reason _reason) {
			if (_reason != null) {
				this.reason.add(_reason.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder addReason(Reason _reason, int idx) {
			getIndex(this.reason, idx, () -> _reason.toBuilder());
			return this;
		}
		
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder addReason(List<? extends Reason> reasons) {
			if (reasons != null) {
				for (final Reason toAdd : reasons) {
					this.reason.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("reason")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("reason")
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder setReason(List<? extends Reason> reasons) {
			if (reasons == null) {
				this.reason = new ArrayList<>();
			} else {
				this.reason = reasons.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("additionalData")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("additionalData")
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder setAdditionalData(AdditionalData _additionalData) {
			this.additionalData = _additionalData == null ? null : _additionalData.toBuilder();
			return this;
		}
		
		@Override
		public RegulatoryReportingException build() {
			return new RegulatoryReportingException.RegulatoryReportingExceptionImpl(this);
		}
		
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder prune() {
			super.prune();
			if (header!=null && !header.prune().hasData()) header = null;
			reason = reason.stream().filter(b->b!=null).<Reason.ReasonBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			if (additionalData!=null && !additionalData.prune().hasData()) additionalData = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getHeader()!=null && getHeader().hasData()) return true;
			if (getReason()!=null && getReason().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getAdditionalData()!=null && getAdditionalData().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegulatoryReportingException.RegulatoryReportingExceptionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegulatoryReportingException.RegulatoryReportingExceptionBuilder o = (RegulatoryReportingException.RegulatoryReportingExceptionBuilder) other;
			
			merger.mergeRosetta(getHeader(), o.getHeader(), this::setHeader);
			merger.mergeRosetta(getReason(), o.getReason(), this::getOrCreateReason);
			merger.mergeRosetta(getAdditionalData(), o.getAdditionalData(), this::setAdditionalData);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegulatoryReportingException _that = getType().cast(o);
		
			if (!Objects.equals(header, _that.getHeader())) return false;
			if (!ListEquals.listEquals(reason, _that.getReason())) return false;
			if (!Objects.equals(additionalData, _that.getAdditionalData())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (header != null ? header.hashCode() : 0);
			_result = 31 * _result + (reason != null ? reason.hashCode() : 0);
			_result = 31 * _result + (additionalData != null ? additionalData.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegulatoryReportingExceptionBuilder {" +
				"header=" + this.header + ", " +
				"reason=" + this.reason + ", " +
				"additionalData=" + this.additionalData +
			'}' + " " + super.toString();
		}
	}
}
