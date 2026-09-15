package drr.standards.iosco.upi;

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
import drr.standards.iosco.upi.meta.AnnaDsbIdentifierMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="AnnaDsbIdentifier", builder=AnnaDsbIdentifier.AnnaDsbIdentifierBuilderImpl.class, version="7.7.0")
@RuneDataType(value="AnnaDsbIdentifier", model="drr", builder=AnnaDsbIdentifier.AnnaDsbIdentifierBuilderImpl.class, version="7.7.0")
public interface AnnaDsbIdentifier extends RosettaModelObject {

	AnnaDsbIdentifierMeta metaData = new AnnaDsbIdentifierMeta();

	/*********************** Getter Methods  ***********************/
	AnnaDsbStatusEnum getStatus();
	String getLastUpdateDateTime();
	String getStatusReason();
	String getUPI();

	/*********************** Build Methods  ***********************/
	AnnaDsbIdentifier build();
	
	AnnaDsbIdentifier.AnnaDsbIdentifierBuilder toBuilder();
	
	static AnnaDsbIdentifier.AnnaDsbIdentifierBuilder builder() {
		return new AnnaDsbIdentifier.AnnaDsbIdentifierBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends AnnaDsbIdentifier> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends AnnaDsbIdentifier> getType() {
		return AnnaDsbIdentifier.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("Status"), AnnaDsbStatusEnum.class, getStatus(), this);
		processor.processBasic(path.newSubPath("LastUpdateDateTime"), String.class, getLastUpdateDateTime(), this);
		processor.processBasic(path.newSubPath("StatusReason"), String.class, getStatusReason(), this);
		processor.processBasic(path.newSubPath("UPI"), String.class, getUPI(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface AnnaDsbIdentifierBuilder extends AnnaDsbIdentifier, RosettaModelObjectBuilder {
		AnnaDsbIdentifier.AnnaDsbIdentifierBuilder setStatus(AnnaDsbStatusEnum Status);
		AnnaDsbIdentifier.AnnaDsbIdentifierBuilder setLastUpdateDateTime(String LastUpdateDateTime);
		AnnaDsbIdentifier.AnnaDsbIdentifierBuilder setStatusReason(String StatusReason);
		AnnaDsbIdentifier.AnnaDsbIdentifierBuilder setUPI(String UPI);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("Status"), AnnaDsbStatusEnum.class, getStatus(), this);
			processor.processBasic(path.newSubPath("LastUpdateDateTime"), String.class, getLastUpdateDateTime(), this);
			processor.processBasic(path.newSubPath("StatusReason"), String.class, getStatusReason(), this);
			processor.processBasic(path.newSubPath("UPI"), String.class, getUPI(), this);
		}
		

		AnnaDsbIdentifier.AnnaDsbIdentifierBuilder prune();
	}

	/*********************** Immutable Implementation of AnnaDsbIdentifier  ***********************/
	class AnnaDsbIdentifierImpl implements AnnaDsbIdentifier {
		private final AnnaDsbStatusEnum status;
		private final String lastUpdateDateTime;
		private final String statusReason;
		private final String uPI;
		
		protected AnnaDsbIdentifierImpl(AnnaDsbIdentifier.AnnaDsbIdentifierBuilder builder) {
			this.status = builder.getStatus();
			this.lastUpdateDateTime = builder.getLastUpdateDateTime();
			this.statusReason = builder.getStatusReason();
			this.uPI = builder.getUPI();
		}
		
		@Override
		@RosettaAttribute("Status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Status")
		public AnnaDsbStatusEnum getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("LastUpdateDateTime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("LastUpdateDateTime")
		public String getLastUpdateDateTime() {
			return lastUpdateDateTime;
		}
		
		@Override
		@RosettaAttribute("StatusReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("StatusReason")
		public String getStatusReason() {
			return statusReason;
		}
		
		@Override
		@RosettaAttribute("UPI")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UPI")
		public String getUPI() {
			return uPI;
		}
		
		@Override
		public AnnaDsbIdentifier build() {
			return this;
		}
		
		@Override
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder toBuilder() {
			AnnaDsbIdentifier.AnnaDsbIdentifierBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(AnnaDsbIdentifier.AnnaDsbIdentifierBuilder builder) {
			ofNullable(getStatus()).ifPresent(builder::setStatus);
			ofNullable(getLastUpdateDateTime()).ifPresent(builder::setLastUpdateDateTime);
			ofNullable(getStatusReason()).ifPresent(builder::setStatusReason);
			ofNullable(getUPI()).ifPresent(builder::setUPI);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(lastUpdateDateTime, _that.getLastUpdateDateTime())) return false;
			if (!Objects.equals(statusReason, _that.getStatusReason())) return false;
			if (!Objects.equals(uPI, _that.getUPI())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (status != null ? status.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (lastUpdateDateTime != null ? lastUpdateDateTime.hashCode() : 0);
			_result = 31 * _result + (statusReason != null ? statusReason.hashCode() : 0);
			_result = 31 * _result + (uPI != null ? uPI.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbIdentifier {" +
				"Status=" + this.status + ", " +
				"LastUpdateDateTime=" + this.lastUpdateDateTime + ", " +
				"StatusReason=" + this.statusReason + ", " +
				"UPI=" + this.uPI +
			'}';
		}
	}

	/*********************** Builder Implementation of AnnaDsbIdentifier  ***********************/
	class AnnaDsbIdentifierBuilderImpl implements AnnaDsbIdentifier.AnnaDsbIdentifierBuilder {
	
		protected AnnaDsbStatusEnum status;
		protected String lastUpdateDateTime;
		protected String statusReason;
		protected String uPI;
		
		@Override
		@RosettaAttribute("Status")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("Status")
		public AnnaDsbStatusEnum getStatus() {
			return status;
		}
		
		@Override
		@RosettaAttribute("LastUpdateDateTime")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("LastUpdateDateTime")
		public String getLastUpdateDateTime() {
			return lastUpdateDateTime;
		}
		
		@Override
		@RosettaAttribute("StatusReason")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("StatusReason")
		public String getStatusReason() {
			return statusReason;
		}
		
		@Override
		@RosettaAttribute("UPI")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("UPI")
		public String getUPI() {
			return uPI;
		}
		
		@RosettaAttribute("Status")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("Status")
		@Override
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder setStatus(AnnaDsbStatusEnum _status) {
			this.status = _status == null ? null : _status;
			return this;
		}
		
		@RosettaAttribute("LastUpdateDateTime")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("LastUpdateDateTime")
		@Override
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder setLastUpdateDateTime(String _lastUpdateDateTime) {
			this.lastUpdateDateTime = _lastUpdateDateTime == null ? null : _lastUpdateDateTime;
			return this;
		}
		
		@RosettaAttribute("StatusReason")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("StatusReason")
		@Override
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder setStatusReason(String _statusReason) {
			this.statusReason = _statusReason == null ? null : _statusReason;
			return this;
		}
		
		@RosettaAttribute("UPI")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("UPI")
		@Override
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder setUPI(String _uPI) {
			this.uPI = _uPI == null ? null : _uPI;
			return this;
		}
		
		@Override
		public AnnaDsbIdentifier build() {
			return new AnnaDsbIdentifier.AnnaDsbIdentifierImpl(this);
		}
		
		@Override
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStatus()!=null) return true;
			if (getLastUpdateDateTime()!=null) return true;
			if (getStatusReason()!=null) return true;
			if (getUPI()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public AnnaDsbIdentifier.AnnaDsbIdentifierBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			AnnaDsbIdentifier.AnnaDsbIdentifierBuilder o = (AnnaDsbIdentifier.AnnaDsbIdentifierBuilder) other;
			
			
			merger.mergeBasic(getStatus(), o.getStatus(), this::setStatus);
			merger.mergeBasic(getLastUpdateDateTime(), o.getLastUpdateDateTime(), this::setLastUpdateDateTime);
			merger.mergeBasic(getStatusReason(), o.getStatusReason(), this::setStatusReason);
			merger.mergeBasic(getUPI(), o.getUPI(), this::setUPI);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			AnnaDsbIdentifier _that = getType().cast(o);
		
			if (!Objects.equals(status, _that.getStatus())) return false;
			if (!Objects.equals(lastUpdateDateTime, _that.getLastUpdateDateTime())) return false;
			if (!Objects.equals(statusReason, _that.getStatusReason())) return false;
			if (!Objects.equals(uPI, _that.getUPI())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (status != null ? status.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (lastUpdateDateTime != null ? lastUpdateDateTime.hashCode() : 0);
			_result = 31 * _result + (statusReason != null ? statusReason.hashCode() : 0);
			_result = 31 * _result + (uPI != null ? uPI.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "AnnaDsbIdentifierBuilder {" +
				"Status=" + this.status + ", " +
				"LastUpdateDateTime=" + this.lastUpdateDateTime + ", " +
				"StatusReason=" + this.statusReason + ", " +
				"UPI=" + this.uPI +
			'}';
		}
	}
}
