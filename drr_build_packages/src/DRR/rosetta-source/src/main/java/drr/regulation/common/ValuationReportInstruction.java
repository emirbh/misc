package drr.regulation.common;

import cdm.base.staticdata.identifier.Identifier;
import cdm.product.collateral.Collateral;
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
import drr.base.trade.ReportingSide;
import drr.regulation.common.meta.ValuationReportInstructionMeta;
import drr.standards.iso.ReportLevelEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies a reportable valuation with with a single reporting side.
 * @version 7.7.0
 */
@RosettaDataType(value="ValuationReportInstruction", builder=ValuationReportInstruction.ValuationReportInstructionBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ValuationReportInstruction", model="drr", builder=ValuationReportInstruction.ValuationReportInstructionBuilderImpl.class, version="7.7.0")
public interface ValuationReportInstruction extends ReportableValuation {

	ValuationReportInstructionMeta metaData = new ValuationReportInstructionMeta();

	/*********************** Getter Methods  ***********************/
	ReportingSide getReportingSide();

	/*********************** Build Methods  ***********************/
	ValuationReportInstruction build();
	
	ValuationReportInstruction.ValuationReportInstructionBuilder toBuilder();
	
	static ValuationReportInstruction.ValuationReportInstructionBuilder builder() {
		return new ValuationReportInstruction.ValuationReportInstructionBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ValuationReportInstruction> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ValuationReportInstruction> getType() {
		return ValuationReportInstruction.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuationDetails"), processor, ValuationDetails.class, getValuationDetails());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.class, getReportableInformation());
		processRosetta(path.newSubPath("collateralDetails"), processor, Collateral.class, getCollateralDetails());
		processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.class, getEventIdentifier());
		processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
		processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.class, getReportingSide());
	}
	

	/*********************** Builder Interface  ***********************/
	interface ValuationReportInstructionBuilder extends ValuationReportInstruction, ReportableValuation.ReportableValuationBuilder {
		ReportingSide.ReportingSideBuilder getOrCreateReportingSide();
		@Override
		ReportingSide.ReportingSideBuilder getReportingSide();
		@Override
		ValuationReportInstruction.ValuationReportInstructionBuilder setValuationDetails(ValuationDetails valuationDetails);
		@Override
		ValuationReportInstruction.ValuationReportInstructionBuilder setReportableInformation(ReportableInformation reportableInformation);
		@Override
		ValuationReportInstruction.ValuationReportInstructionBuilder setCollateralDetails(Collateral collateralDetails);
		@Override
		ValuationReportInstruction.ValuationReportInstructionBuilder addEventIdentifier(Identifier eventIdentifier);
		@Override
		ValuationReportInstruction.ValuationReportInstructionBuilder addEventIdentifier(Identifier eventIdentifier, int idx);
		@Override
		ValuationReportInstruction.ValuationReportInstructionBuilder addEventIdentifier(List<? extends Identifier> eventIdentifier);
		@Override
		ValuationReportInstruction.ValuationReportInstructionBuilder setEventIdentifier(List<? extends Identifier> eventIdentifier);
		@Override
		ValuationReportInstruction.ValuationReportInstructionBuilder setLevel(ReportLevelEnum level);
		ValuationReportInstruction.ValuationReportInstructionBuilder setReportingSide(ReportingSide reportingSide);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuationDetails"), processor, ValuationDetails.ValuationDetailsBuilder.class, getValuationDetails());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.ReportableInformationBuilder.class, getReportableInformation());
			processRosetta(path.newSubPath("collateralDetails"), processor, Collateral.CollateralBuilder.class, getCollateralDetails());
			processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.IdentifierBuilder.class, getEventIdentifier());
			processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
			processRosetta(path.newSubPath("reportingSide"), processor, ReportingSide.ReportingSideBuilder.class, getReportingSide());
		}
		

		ValuationReportInstruction.ValuationReportInstructionBuilder prune();
	}

	/*********************** Immutable Implementation of ValuationReportInstruction  ***********************/
	class ValuationReportInstructionImpl extends ReportableValuation.ReportableValuationImpl implements ValuationReportInstruction {
		private final ReportingSide reportingSide;
		
		protected ValuationReportInstructionImpl(ValuationReportInstruction.ValuationReportInstructionBuilder builder) {
			super(builder);
			this.reportingSide = ofNullable(builder.getReportingSide()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingSide")
		public ReportingSide getReportingSide() {
			return reportingSide;
		}
		
		@Override
		public ValuationReportInstruction build() {
			return this;
		}
		
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder toBuilder() {
			ValuationReportInstruction.ValuationReportInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ValuationReportInstruction.ValuationReportInstructionBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getReportingSide()).ifPresent(builder::setReportingSide);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationReportInstruction _that = getType().cast(o);
		
			if (!Objects.equals(reportingSide, _that.getReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportingSide != null ? reportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationReportInstruction {" +
				"reportingSide=" + this.reportingSide +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of ValuationReportInstruction  ***********************/
	class ValuationReportInstructionBuilderImpl extends ReportableValuation.ReportableValuationBuilderImpl implements ValuationReportInstruction.ValuationReportInstructionBuilder {
	
		protected ReportingSide.ReportingSideBuilder reportingSide;
		
		@Override
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportingSide")
		public ReportingSide.ReportingSideBuilder getReportingSide() {
			return reportingSide;
		}
		
		@Override
		public ReportingSide.ReportingSideBuilder getOrCreateReportingSide() {
			ReportingSide.ReportingSideBuilder result;
			if (reportingSide!=null) {
				result = reportingSide;
			}
			else {
				result = reportingSide = ReportingSide.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("valuationDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDetails")
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder setValuationDetails(ValuationDetails _valuationDetails) {
			this.valuationDetails = _valuationDetails == null ? null : _valuationDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder setReportableInformation(ReportableInformation _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralDetails")
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder setCollateralDetails(Collateral _collateralDetails) {
			this.collateralDetails = _collateralDetails == null ? null : _collateralDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder addEventIdentifier(Identifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder addEventIdentifier(Identifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder addEventIdentifier(List<? extends Identifier> eventIdentifiers) {
			if (eventIdentifiers != null) {
				for (final Identifier toAdd : eventIdentifiers) {
					this.eventIdentifier.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder setEventIdentifier(List<? extends Identifier> eventIdentifiers) {
			if (eventIdentifiers == null) {
				this.eventIdentifier = new ArrayList<>();
			} else {
				this.eventIdentifier = eventIdentifiers.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@RosettaAttribute("level")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("level")
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("reportingSide")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportingSide")
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder setReportingSide(ReportingSide _reportingSide) {
			this.reportingSide = _reportingSide == null ? null : _reportingSide.toBuilder();
			return this;
		}
		
		@Override
		public ValuationReportInstruction build() {
			return new ValuationReportInstruction.ValuationReportInstructionImpl(this);
		}
		
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder prune() {
			super.prune();
			if (reportingSide!=null && !reportingSide.prune().hasData()) reportingSide = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getReportingSide()!=null && getReportingSide().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ValuationReportInstruction.ValuationReportInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			ValuationReportInstruction.ValuationReportInstructionBuilder o = (ValuationReportInstruction.ValuationReportInstructionBuilder) other;
			
			merger.mergeRosetta(getReportingSide(), o.getReportingSide(), this::setReportingSide);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			ValuationReportInstruction _that = getType().cast(o);
		
			if (!Objects.equals(reportingSide, _that.getReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (reportingSide != null ? reportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ValuationReportInstructionBuilder {" +
				"reportingSide=" + this.reportingSide +
			'}' + " " + super.toString();
		}
	}
}
