package drr.base.margin;

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
import drr.base.margin.meta.ReportableCollateralBaseMeta;
import drr.base.trade.ReportableInformationBase;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableCollateralBase", builder=ReportableCollateralBase.ReportableCollateralBaseBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableCollateralBase", model="drr", builder=ReportableCollateralBase.ReportableCollateralBaseBuilderImpl.class, version="7.7.0")
public interface ReportableCollateralBase extends RosettaModelObject {

	ReportableCollateralBaseMeta metaData = new ReportableCollateralBaseMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reportable collateral information
	 */
	CollateralDetails getCollateralDetails();
	ReportableInformationBase getReportableInformation();

	/*********************** Build Methods  ***********************/
	ReportableCollateralBase build();
	
	ReportableCollateralBase.ReportableCollateralBaseBuilder toBuilder();
	
	static ReportableCollateralBase.ReportableCollateralBaseBuilder builder() {
		return new ReportableCollateralBase.ReportableCollateralBaseBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableCollateralBase> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableCollateralBase> getType() {
		return ReportableCollateralBase.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.class, getCollateralDetails());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformationBase.class, getReportableInformation());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableCollateralBaseBuilder extends ReportableCollateralBase, RosettaModelObjectBuilder {
		CollateralDetails.CollateralDetailsBuilder getOrCreateCollateralDetails();
		@Override
		CollateralDetails.CollateralDetailsBuilder getCollateralDetails();
		ReportableInformationBase.ReportableInformationBaseBuilder getOrCreateReportableInformation();
		@Override
		ReportableInformationBase.ReportableInformationBaseBuilder getReportableInformation();
		ReportableCollateralBase.ReportableCollateralBaseBuilder setCollateralDetails(CollateralDetails collateralDetails);
		ReportableCollateralBase.ReportableCollateralBaseBuilder setReportableInformation(ReportableInformationBase reportableInformation);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.CollateralDetailsBuilder.class, getCollateralDetails());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformationBase.ReportableInformationBaseBuilder.class, getReportableInformation());
		}
		

		ReportableCollateralBase.ReportableCollateralBaseBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableCollateralBase  ***********************/
	class ReportableCollateralBaseImpl implements ReportableCollateralBase {
		private final CollateralDetails collateralDetails;
		private final ReportableInformationBase reportableInformation;
		
		protected ReportableCollateralBaseImpl(ReportableCollateralBase.ReportableCollateralBaseBuilder builder) {
			this.collateralDetails = ofNullable(builder.getCollateralDetails()).map(f->f.build()).orElse(null);
			this.reportableInformation = ofNullable(builder.getReportableInformation()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralDetails")
		public CollateralDetails getCollateralDetails() {
			return collateralDetails;
		}
		
		@Override
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableInformation")
		public ReportableInformationBase getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		public ReportableCollateralBase build() {
			return this;
		}
		
		@Override
		public ReportableCollateralBase.ReportableCollateralBaseBuilder toBuilder() {
			ReportableCollateralBase.ReportableCollateralBaseBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableCollateralBase.ReportableCollateralBaseBuilder builder) {
			ofNullable(getCollateralDetails()).ifPresent(builder::setCollateralDetails);
			ofNullable(getReportableInformation()).ifPresent(builder::setReportableInformation);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableCollateralBase _that = getType().cast(o);
		
			if (!Objects.equals(collateralDetails, _that.getCollateralDetails())) return false;
			if (!Objects.equals(reportableInformation, _that.getReportableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralDetails != null ? collateralDetails.hashCode() : 0);
			_result = 31 * _result + (reportableInformation != null ? reportableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableCollateralBase {" +
				"collateralDetails=" + this.collateralDetails + ", " +
				"reportableInformation=" + this.reportableInformation +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportableCollateralBase  ***********************/
	class ReportableCollateralBaseBuilderImpl implements ReportableCollateralBase.ReportableCollateralBaseBuilder {
	
		protected CollateralDetails.CollateralDetailsBuilder collateralDetails;
		protected ReportableInformationBase.ReportableInformationBaseBuilder reportableInformation;
		
		@Override
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralDetails")
		public CollateralDetails.CollateralDetailsBuilder getCollateralDetails() {
			return collateralDetails;
		}
		
		@Override
		public CollateralDetails.CollateralDetailsBuilder getOrCreateCollateralDetails() {
			CollateralDetails.CollateralDetailsBuilder result;
			if (collateralDetails!=null) {
				result = collateralDetails;
			}
			else {
				result = collateralDetails = CollateralDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableInformation")
		public ReportableInformationBase.ReportableInformationBaseBuilder getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		public ReportableInformationBase.ReportableInformationBaseBuilder getOrCreateReportableInformation() {
			ReportableInformationBase.ReportableInformationBaseBuilder result;
			if (reportableInformation!=null) {
				result = reportableInformation;
			}
			else {
				result = reportableInformation = ReportableInformationBase.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralDetails")
		@Override
		public ReportableCollateralBase.ReportableCollateralBaseBuilder setCollateralDetails(CollateralDetails _collateralDetails) {
			this.collateralDetails = _collateralDetails == null ? null : _collateralDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public ReportableCollateralBase.ReportableCollateralBaseBuilder setReportableInformation(ReportableInformationBase _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@Override
		public ReportableCollateralBase build() {
			return new ReportableCollateralBase.ReportableCollateralBaseImpl(this);
		}
		
		@Override
		public ReportableCollateralBase.ReportableCollateralBaseBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableCollateralBase.ReportableCollateralBaseBuilder prune() {
			if (collateralDetails!=null && !collateralDetails.prune().hasData()) collateralDetails = null;
			if (reportableInformation!=null && !reportableInformation.prune().hasData()) reportableInformation = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollateralDetails()!=null && getCollateralDetails().hasData()) return true;
			if (getReportableInformation()!=null && getReportableInformation().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableCollateralBase.ReportableCollateralBaseBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportableCollateralBase.ReportableCollateralBaseBuilder o = (ReportableCollateralBase.ReportableCollateralBaseBuilder) other;
			
			merger.mergeRosetta(getCollateralDetails(), o.getCollateralDetails(), this::setCollateralDetails);
			merger.mergeRosetta(getReportableInformation(), o.getReportableInformation(), this::setReportableInformation);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableCollateralBase _that = getType().cast(o);
		
			if (!Objects.equals(collateralDetails, _that.getCollateralDetails())) return false;
			if (!Objects.equals(reportableInformation, _that.getReportableInformation())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collateralDetails != null ? collateralDetails.hashCode() : 0);
			_result = 31 * _result + (reportableInformation != null ? reportableInformation.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableCollateralBaseBuilder {" +
				"collateralDetails=" + this.collateralDetails + ", " +
				"reportableInformation=" + this.reportableInformation +
			'}';
		}
	}
}
