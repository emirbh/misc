package drr.regulation.common;

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
import drr.base.trade.ExecutionVenueTypeEnum;
import drr.regulation.common.meta.ReportableExecutionVenueMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Describes the execution venue where the trade is executed.
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableExecutionVenue", builder=ReportableExecutionVenue.ReportableExecutionVenueBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableExecutionVenue", model="drr", builder=ReportableExecutionVenue.ReportableExecutionVenueBuilderImpl.class, version="7.7.0")
public interface ReportableExecutionVenue extends RosettaModelObject {

	ReportableExecutionVenueMeta metaData = new ReportableExecutionVenueMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the type of venue where a trade could be executed.
	 */
	ExecutionVenueTypeEnum getExecutionVenueType();
	/**
	 * Indicator of whether the swap was executed anonymously on a SEF or DCM. When set to true, counterparty details will be masked on reporting.
	 */
	Boolean getSefOrDcmAnonymousIndicator();

	/*********************** Build Methods  ***********************/
	ReportableExecutionVenue build();
	
	ReportableExecutionVenue.ReportableExecutionVenueBuilder toBuilder();
	
	static ReportableExecutionVenue.ReportableExecutionVenueBuilder builder() {
		return new ReportableExecutionVenue.ReportableExecutionVenueBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableExecutionVenue> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableExecutionVenue> getType() {
		return ReportableExecutionVenue.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("executionVenueType"), ExecutionVenueTypeEnum.class, getExecutionVenueType(), this);
		processor.processBasic(path.newSubPath("sefOrDcmAnonymousIndicator"), Boolean.class, getSefOrDcmAnonymousIndicator(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableExecutionVenueBuilder extends ReportableExecutionVenue, RosettaModelObjectBuilder {
		ReportableExecutionVenue.ReportableExecutionVenueBuilder setExecutionVenueType(ExecutionVenueTypeEnum executionVenueType);
		ReportableExecutionVenue.ReportableExecutionVenueBuilder setSefOrDcmAnonymousIndicator(Boolean sefOrDcmAnonymousIndicator);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("executionVenueType"), ExecutionVenueTypeEnum.class, getExecutionVenueType(), this);
			processor.processBasic(path.newSubPath("sefOrDcmAnonymousIndicator"), Boolean.class, getSefOrDcmAnonymousIndicator(), this);
		}
		

		ReportableExecutionVenue.ReportableExecutionVenueBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableExecutionVenue  ***********************/
	class ReportableExecutionVenueImpl implements ReportableExecutionVenue {
		private final ExecutionVenueTypeEnum executionVenueType;
		private final Boolean sefOrDcmAnonymousIndicator;
		
		protected ReportableExecutionVenueImpl(ReportableExecutionVenue.ReportableExecutionVenueBuilder builder) {
			this.executionVenueType = builder.getExecutionVenueType();
			this.sefOrDcmAnonymousIndicator = builder.getSefOrDcmAnonymousIndicator();
		}
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionVenueType")
		public ExecutionVenueTypeEnum getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		@RosettaAttribute("sefOrDcmAnonymousIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sefOrDcmAnonymousIndicator")
		public Boolean getSefOrDcmAnonymousIndicator() {
			return sefOrDcmAnonymousIndicator;
		}
		
		@Override
		public ReportableExecutionVenue build() {
			return this;
		}
		
		@Override
		public ReportableExecutionVenue.ReportableExecutionVenueBuilder toBuilder() {
			ReportableExecutionVenue.ReportableExecutionVenueBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableExecutionVenue.ReportableExecutionVenueBuilder builder) {
			ofNullable(getExecutionVenueType()).ifPresent(builder::setExecutionVenueType);
			ofNullable(getSefOrDcmAnonymousIndicator()).ifPresent(builder::setSefOrDcmAnonymousIndicator);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableExecutionVenue _that = getType().cast(o);
		
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(sefOrDcmAnonymousIndicator, _that.getSefOrDcmAnonymousIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (sefOrDcmAnonymousIndicator != null ? sefOrDcmAnonymousIndicator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableExecutionVenue {" +
				"executionVenueType=" + this.executionVenueType + ", " +
				"sefOrDcmAnonymousIndicator=" + this.sefOrDcmAnonymousIndicator +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportableExecutionVenue  ***********************/
	class ReportableExecutionVenueBuilderImpl implements ReportableExecutionVenue.ReportableExecutionVenueBuilder {
	
		protected ExecutionVenueTypeEnum executionVenueType;
		protected Boolean sefOrDcmAnonymousIndicator;
		
		@Override
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("executionVenueType")
		public ExecutionVenueTypeEnum getExecutionVenueType() {
			return executionVenueType;
		}
		
		@Override
		@RosettaAttribute("sefOrDcmAnonymousIndicator")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("sefOrDcmAnonymousIndicator")
		public Boolean getSefOrDcmAnonymousIndicator() {
			return sefOrDcmAnonymousIndicator;
		}
		
		@RosettaAttribute("executionVenueType")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("executionVenueType")
		@Override
		public ReportableExecutionVenue.ReportableExecutionVenueBuilder setExecutionVenueType(ExecutionVenueTypeEnum _executionVenueType) {
			this.executionVenueType = _executionVenueType == null ? null : _executionVenueType;
			return this;
		}
		
		@RosettaAttribute("sefOrDcmAnonymousIndicator")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("sefOrDcmAnonymousIndicator")
		@Override
		public ReportableExecutionVenue.ReportableExecutionVenueBuilder setSefOrDcmAnonymousIndicator(Boolean _sefOrDcmAnonymousIndicator) {
			this.sefOrDcmAnonymousIndicator = _sefOrDcmAnonymousIndicator == null ? null : _sefOrDcmAnonymousIndicator;
			return this;
		}
		
		@Override
		public ReportableExecutionVenue build() {
			return new ReportableExecutionVenue.ReportableExecutionVenueImpl(this);
		}
		
		@Override
		public ReportableExecutionVenue.ReportableExecutionVenueBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableExecutionVenue.ReportableExecutionVenueBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExecutionVenueType()!=null) return true;
			if (getSefOrDcmAnonymousIndicator()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableExecutionVenue.ReportableExecutionVenueBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportableExecutionVenue.ReportableExecutionVenueBuilder o = (ReportableExecutionVenue.ReportableExecutionVenueBuilder) other;
			
			
			merger.mergeBasic(getExecutionVenueType(), o.getExecutionVenueType(), this::setExecutionVenueType);
			merger.mergeBasic(getSefOrDcmAnonymousIndicator(), o.getSefOrDcmAnonymousIndicator(), this::setSefOrDcmAnonymousIndicator);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableExecutionVenue _that = getType().cast(o);
		
			if (!Objects.equals(executionVenueType, _that.getExecutionVenueType())) return false;
			if (!Objects.equals(sefOrDcmAnonymousIndicator, _that.getSefOrDcmAnonymousIndicator())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (executionVenueType != null ? executionVenueType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (sefOrDcmAnonymousIndicator != null ? sefOrDcmAnonymousIndicator.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableExecutionVenueBuilder {" +
				"executionVenueType=" + this.executionVenueType + ", " +
				"sefOrDcmAnonymousIndicator=" + this.sefOrDcmAnonymousIndicator +
			'}';
		}
	}
}
