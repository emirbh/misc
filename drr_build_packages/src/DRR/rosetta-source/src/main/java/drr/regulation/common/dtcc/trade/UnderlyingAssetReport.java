package drr.regulation.common.dtcc.trade;

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
import drr.regulation.common.dtcc.trade.meta.UnderlyingAssetReportMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="UnderlyingAssetReport", builder=UnderlyingAssetReport.UnderlyingAssetReportBuilderImpl.class, version="7.7.0")
@RuneDataType(value="UnderlyingAssetReport", model="drr", builder=UnderlyingAssetReport.UnderlyingAssetReportBuilderImpl.class, version="7.7.0")
public interface UnderlyingAssetReport extends RosettaModelObject {

	UnderlyingAssetReportMeta metaData = new UnderlyingAssetReportMeta();

	/*********************** Getter Methods  ***********************/
	String getUnderlyingAssetID();
	String getUnderlyingAssetIDType();

	/*********************** Build Methods  ***********************/
	UnderlyingAssetReport build();
	
	UnderlyingAssetReport.UnderlyingAssetReportBuilder toBuilder();
	
	static UnderlyingAssetReport.UnderlyingAssetReportBuilder builder() {
		return new UnderlyingAssetReport.UnderlyingAssetReportBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends UnderlyingAssetReport> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends UnderlyingAssetReport> getType() {
		return UnderlyingAssetReport.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("underlyingAssetID"), String.class, getUnderlyingAssetID(), this);
		processor.processBasic(path.newSubPath("underlyingAssetIDType"), String.class, getUnderlyingAssetIDType(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface UnderlyingAssetReportBuilder extends UnderlyingAssetReport, RosettaModelObjectBuilder {
		UnderlyingAssetReport.UnderlyingAssetReportBuilder setUnderlyingAssetID(String underlyingAssetID);
		UnderlyingAssetReport.UnderlyingAssetReportBuilder setUnderlyingAssetIDType(String underlyingAssetIDType);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("underlyingAssetID"), String.class, getUnderlyingAssetID(), this);
			processor.processBasic(path.newSubPath("underlyingAssetIDType"), String.class, getUnderlyingAssetIDType(), this);
		}
		

		UnderlyingAssetReport.UnderlyingAssetReportBuilder prune();
	}

	/*********************** Immutable Implementation of UnderlyingAssetReport  ***********************/
	class UnderlyingAssetReportImpl implements UnderlyingAssetReport {
		private final String underlyingAssetID;
		private final String underlyingAssetIDType;
		
		protected UnderlyingAssetReportImpl(UnderlyingAssetReport.UnderlyingAssetReportBuilder builder) {
			this.underlyingAssetID = builder.getUnderlyingAssetID();
			this.underlyingAssetIDType = builder.getUnderlyingAssetIDType();
		}
		
		@Override
		@RosettaAttribute("underlyingAssetID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetID")
		public String getUnderlyingAssetID() {
			return underlyingAssetID;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetIDType")
		public String getUnderlyingAssetIDType() {
			return underlyingAssetIDType;
		}
		
		@Override
		public UnderlyingAssetReport build() {
			return this;
		}
		
		@Override
		public UnderlyingAssetReport.UnderlyingAssetReportBuilder toBuilder() {
			UnderlyingAssetReport.UnderlyingAssetReportBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(UnderlyingAssetReport.UnderlyingAssetReportBuilder builder) {
			ofNullable(getUnderlyingAssetID()).ifPresent(builder::setUnderlyingAssetID);
			ofNullable(getUnderlyingAssetIDType()).ifPresent(builder::setUnderlyingAssetIDType);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyingAssetReport _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAssetID, _that.getUnderlyingAssetID())) return false;
			if (!Objects.equals(underlyingAssetIDType, _that.getUnderlyingAssetIDType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAssetID != null ? underlyingAssetID.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetIDType != null ? underlyingAssetIDType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAssetReport {" +
				"underlyingAssetID=" + this.underlyingAssetID + ", " +
				"underlyingAssetIDType=" + this.underlyingAssetIDType +
			'}';
		}
	}

	/*********************** Builder Implementation of UnderlyingAssetReport  ***********************/
	class UnderlyingAssetReportBuilderImpl implements UnderlyingAssetReport.UnderlyingAssetReportBuilder {
	
		protected String underlyingAssetID;
		protected String underlyingAssetIDType;
		
		@Override
		@RosettaAttribute("underlyingAssetID")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetID")
		public String getUnderlyingAssetID() {
			return underlyingAssetID;
		}
		
		@Override
		@RosettaAttribute("underlyingAssetIDType")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("underlyingAssetIDType")
		public String getUnderlyingAssetIDType() {
			return underlyingAssetIDType;
		}
		
		@RosettaAttribute("underlyingAssetID")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetID")
		@Override
		public UnderlyingAssetReport.UnderlyingAssetReportBuilder setUnderlyingAssetID(String _underlyingAssetID) {
			this.underlyingAssetID = _underlyingAssetID == null ? null : _underlyingAssetID;
			return this;
		}
		
		@RosettaAttribute("underlyingAssetIDType")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("underlyingAssetIDType")
		@Override
		public UnderlyingAssetReport.UnderlyingAssetReportBuilder setUnderlyingAssetIDType(String _underlyingAssetIDType) {
			this.underlyingAssetIDType = _underlyingAssetIDType == null ? null : _underlyingAssetIDType;
			return this;
		}
		
		@Override
		public UnderlyingAssetReport build() {
			return new UnderlyingAssetReport.UnderlyingAssetReportImpl(this);
		}
		
		@Override
		public UnderlyingAssetReport.UnderlyingAssetReportBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAssetReport.UnderlyingAssetReportBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlyingAssetID()!=null) return true;
			if (getUnderlyingAssetIDType()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public UnderlyingAssetReport.UnderlyingAssetReportBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			UnderlyingAssetReport.UnderlyingAssetReportBuilder o = (UnderlyingAssetReport.UnderlyingAssetReportBuilder) other;
			
			
			merger.mergeBasic(getUnderlyingAssetID(), o.getUnderlyingAssetID(), this::setUnderlyingAssetID);
			merger.mergeBasic(getUnderlyingAssetIDType(), o.getUnderlyingAssetIDType(), this::setUnderlyingAssetIDType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			UnderlyingAssetReport _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAssetID, _that.getUnderlyingAssetID())) return false;
			if (!Objects.equals(underlyingAssetIDType, _that.getUnderlyingAssetIDType())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAssetID != null ? underlyingAssetID.hashCode() : 0);
			_result = 31 * _result + (underlyingAssetIDType != null ? underlyingAssetIDType.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "UnderlyingAssetReportBuilder {" +
				"underlyingAssetID=" + this.underlyingAssetID + ", " +
				"underlyingAssetIDType=" + this.underlyingAssetIDType +
			'}';
		}
	}
}
