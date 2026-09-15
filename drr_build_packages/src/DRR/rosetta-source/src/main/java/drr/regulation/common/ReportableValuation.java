package drr.regulation.common;

import cdm.base.staticdata.identifier.Identifier;
import cdm.product.collateral.Collateral;
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
import drr.regulation.common.meta.ReportableValuationMeta;
import drr.standards.iso.ReportLevelEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * @version 7.7.0
 */
@RosettaDataType(value="ReportableValuation", builder=ReportableValuation.ReportableValuationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="ReportableValuation", model="drr", builder=ReportableValuation.ReportableValuationBuilderImpl.class, version="7.7.0")
public interface ReportableValuation extends RosettaModelObject {

	ReportableValuationMeta metaData = new ReportableValuationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The reportable valuation information
	 */
	ValuationDetails getValuationDetails();
	/**
	 * Additional information required for a reportable transaction, including the reporting regime.
	 */
	ReportableInformation getReportableInformation();
	/**
	 * Collateral information needed to complement valuation report.
	 */
	Collateral getCollateralDetails();
	/**
	 * Allows user to insert processing identifiers
	 */
	List<? extends Identifier> getEventIdentifier();
	/**
	 * Indication whether the report is done at trade or position level.
	 */
	ReportLevelEnum getLevel();

	/*********************** Build Methods  ***********************/
	ReportableValuation build();
	
	ReportableValuation.ReportableValuationBuilder toBuilder();
	
	static ReportableValuation.ReportableValuationBuilder builder() {
		return new ReportableValuation.ReportableValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends ReportableValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends ReportableValuation> getType() {
		return ReportableValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuationDetails"), processor, ValuationDetails.class, getValuationDetails());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.class, getReportableInformation());
		processRosetta(path.newSubPath("collateralDetails"), processor, Collateral.class, getCollateralDetails());
		processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.class, getEventIdentifier());
		processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface ReportableValuationBuilder extends ReportableValuation, RosettaModelObjectBuilder {
		ValuationDetails.ValuationDetailsBuilder getOrCreateValuationDetails();
		@Override
		ValuationDetails.ValuationDetailsBuilder getValuationDetails();
		ReportableInformation.ReportableInformationBuilder getOrCreateReportableInformation();
		@Override
		ReportableInformation.ReportableInformationBuilder getReportableInformation();
		Collateral.CollateralBuilder getOrCreateCollateralDetails();
		@Override
		Collateral.CollateralBuilder getCollateralDetails();
		Identifier.IdentifierBuilder getOrCreateEventIdentifier(int index);
		@Override
		List<? extends Identifier.IdentifierBuilder> getEventIdentifier();
		ReportableValuation.ReportableValuationBuilder setValuationDetails(ValuationDetails valuationDetails);
		ReportableValuation.ReportableValuationBuilder setReportableInformation(ReportableInformation reportableInformation);
		ReportableValuation.ReportableValuationBuilder setCollateralDetails(Collateral collateralDetails);
		ReportableValuation.ReportableValuationBuilder addEventIdentifier(Identifier eventIdentifier);
		ReportableValuation.ReportableValuationBuilder addEventIdentifier(Identifier eventIdentifier, int idx);
		ReportableValuation.ReportableValuationBuilder addEventIdentifier(List<? extends Identifier> eventIdentifier);
		ReportableValuation.ReportableValuationBuilder setEventIdentifier(List<? extends Identifier> eventIdentifier);
		ReportableValuation.ReportableValuationBuilder setLevel(ReportLevelEnum level);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuationDetails"), processor, ValuationDetails.ValuationDetailsBuilder.class, getValuationDetails());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.ReportableInformationBuilder.class, getReportableInformation());
			processRosetta(path.newSubPath("collateralDetails"), processor, Collateral.CollateralBuilder.class, getCollateralDetails());
			processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.IdentifierBuilder.class, getEventIdentifier());
			processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
		}
		

		ReportableValuation.ReportableValuationBuilder prune();
	}

	/*********************** Immutable Implementation of ReportableValuation  ***********************/
	class ReportableValuationImpl implements ReportableValuation {
		private final ValuationDetails valuationDetails;
		private final ReportableInformation reportableInformation;
		private final Collateral collateralDetails;
		private final List<? extends Identifier> eventIdentifier;
		private final ReportLevelEnum level;
		
		protected ReportableValuationImpl(ReportableValuation.ReportableValuationBuilder builder) {
			this.valuationDetails = ofNullable(builder.getValuationDetails()).map(f->f.build()).orElse(null);
			this.reportableInformation = ofNullable(builder.getReportableInformation()).map(f->f.build()).orElse(null);
			this.collateralDetails = ofNullable(builder.getCollateralDetails()).map(f->f.build()).orElse(null);
			this.eventIdentifier = ofNullable(builder.getEventIdentifier()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
			this.level = builder.getLevel();
		}
		
		@Override
		@RosettaAttribute("valuationDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDetails")
		public ValuationDetails getValuationDetails() {
			return valuationDetails;
		}
		
		@Override
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableInformation")
		public ReportableInformation getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralDetails")
		public Collateral getCollateralDetails() {
			return collateralDetails;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		public List<? extends Identifier> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public ReportLevelEnum getLevel() {
			return level;
		}
		
		@Override
		public ReportableValuation build() {
			return this;
		}
		
		@Override
		public ReportableValuation.ReportableValuationBuilder toBuilder() {
			ReportableValuation.ReportableValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReportableValuation.ReportableValuationBuilder builder) {
			ofNullable(getValuationDetails()).ifPresent(builder::setValuationDetails);
			ofNullable(getReportableInformation()).ifPresent(builder::setReportableInformation);
			ofNullable(getCollateralDetails()).ifPresent(builder::setCollateralDetails);
			ofNullable(getEventIdentifier()).ifPresent(builder::setEventIdentifier);
			ofNullable(getLevel()).ifPresent(builder::setLevel);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableValuation _that = getType().cast(o);
		
			if (!Objects.equals(valuationDetails, _that.getValuationDetails())) return false;
			if (!Objects.equals(reportableInformation, _that.getReportableInformation())) return false;
			if (!Objects.equals(collateralDetails, _that.getCollateralDetails())) return false;
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationDetails != null ? valuationDetails.hashCode() : 0);
			_result = 31 * _result + (reportableInformation != null ? reportableInformation.hashCode() : 0);
			_result = 31 * _result + (collateralDetails != null ? collateralDetails.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableValuation {" +
				"valuationDetails=" + this.valuationDetails + ", " +
				"reportableInformation=" + this.reportableInformation + ", " +
				"collateralDetails=" + this.collateralDetails + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"level=" + this.level +
			'}';
		}
	}

	/*********************** Builder Implementation of ReportableValuation  ***********************/
	class ReportableValuationBuilderImpl implements ReportableValuation.ReportableValuationBuilder {
	
		protected ValuationDetails.ValuationDetailsBuilder valuationDetails;
		protected ReportableInformation.ReportableInformationBuilder reportableInformation;
		protected Collateral.CollateralBuilder collateralDetails;
		protected List<Identifier.IdentifierBuilder> eventIdentifier = new ArrayList<>();
		protected ReportLevelEnum level;
		
		@Override
		@RosettaAttribute("valuationDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("valuationDetails")
		public ValuationDetails.ValuationDetailsBuilder getValuationDetails() {
			return valuationDetails;
		}
		
		@Override
		public ValuationDetails.ValuationDetailsBuilder getOrCreateValuationDetails() {
			ValuationDetails.ValuationDetailsBuilder result;
			if (valuationDetails!=null) {
				result = valuationDetails;
			}
			else {
				result = valuationDetails = ValuationDetails.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("reportableInformation")
		public ReportableInformation.ReportableInformationBuilder getReportableInformation() {
			return reportableInformation;
		}
		
		@Override
		public ReportableInformation.ReportableInformationBuilder getOrCreateReportableInformation() {
			ReportableInformation.ReportableInformationBuilder result;
			if (reportableInformation!=null) {
				result = reportableInformation;
			}
			else {
				result = reportableInformation = ReportableInformation.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("collateralDetails")
		public Collateral.CollateralBuilder getCollateralDetails() {
			return collateralDetails;
		}
		
		@Override
		public Collateral.CollateralBuilder getOrCreateCollateralDetails() {
			Collateral.CollateralBuilder result;
			if (collateralDetails!=null) {
				result = collateralDetails;
			}
			else {
				result = collateralDetails = Collateral.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("eventIdentifier")
		public List<? extends Identifier.IdentifierBuilder> getEventIdentifier() {
			return eventIdentifier;
		}
		
		@Override
		public Identifier.IdentifierBuilder getOrCreateEventIdentifier(int index) {
			if (eventIdentifier==null) {
				this.eventIdentifier = new ArrayList<>();
			}
			return getIndex(eventIdentifier, index, () -> {
						Identifier.IdentifierBuilder newEventIdentifier = Identifier.builder();
						return newEventIdentifier;
					});
		}
		
		@Override
		@RosettaAttribute("level")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("level")
		public ReportLevelEnum getLevel() {
			return level;
		}
		
		@RosettaAttribute("valuationDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDetails")
		@Override
		public ReportableValuation.ReportableValuationBuilder setValuationDetails(ValuationDetails _valuationDetails) {
			this.valuationDetails = _valuationDetails == null ? null : _valuationDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public ReportableValuation.ReportableValuationBuilder setReportableInformation(ReportableInformation _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralDetails")
		@Override
		public ReportableValuation.ReportableValuationBuilder setCollateralDetails(Collateral _collateralDetails) {
			this.collateralDetails = _collateralDetails == null ? null : _collateralDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public ReportableValuation.ReportableValuationBuilder addEventIdentifier(Identifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public ReportableValuation.ReportableValuationBuilder addEventIdentifier(Identifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public ReportableValuation.ReportableValuationBuilder addEventIdentifier(List<? extends Identifier> eventIdentifiers) {
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
		public ReportableValuation.ReportableValuationBuilder setEventIdentifier(List<? extends Identifier> eventIdentifiers) {
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
		public ReportableValuation.ReportableValuationBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@Override
		public ReportableValuation build() {
			return new ReportableValuation.ReportableValuationImpl(this);
		}
		
		@Override
		public ReportableValuation.ReportableValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableValuation.ReportableValuationBuilder prune() {
			if (valuationDetails!=null && !valuationDetails.prune().hasData()) valuationDetails = null;
			if (reportableInformation!=null && !reportableInformation.prune().hasData()) reportableInformation = null;
			if (collateralDetails!=null && !collateralDetails.prune().hasData()) collateralDetails = null;
			eventIdentifier = eventIdentifier.stream().filter(b->b!=null).<Identifier.IdentifierBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getValuationDetails()!=null && getValuationDetails().hasData()) return true;
			if (getReportableInformation()!=null && getReportableInformation().hasData()) return true;
			if (getCollateralDetails()!=null && getCollateralDetails().hasData()) return true;
			if (getEventIdentifier()!=null && getEventIdentifier().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			if (getLevel()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReportableValuation.ReportableValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReportableValuation.ReportableValuationBuilder o = (ReportableValuation.ReportableValuationBuilder) other;
			
			merger.mergeRosetta(getValuationDetails(), o.getValuationDetails(), this::setValuationDetails);
			merger.mergeRosetta(getReportableInformation(), o.getReportableInformation(), this::setReportableInformation);
			merger.mergeRosetta(getCollateralDetails(), o.getCollateralDetails(), this::setCollateralDetails);
			merger.mergeRosetta(getEventIdentifier(), o.getEventIdentifier(), this::getOrCreateEventIdentifier);
			
			merger.mergeBasic(getLevel(), o.getLevel(), this::setLevel);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReportableValuation _that = getType().cast(o);
		
			if (!Objects.equals(valuationDetails, _that.getValuationDetails())) return false;
			if (!Objects.equals(reportableInformation, _that.getReportableInformation())) return false;
			if (!Objects.equals(collateralDetails, _that.getCollateralDetails())) return false;
			if (!ListEquals.listEquals(eventIdentifier, _that.getEventIdentifier())) return false;
			if (!Objects.equals(level, _that.getLevel())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (valuationDetails != null ? valuationDetails.hashCode() : 0);
			_result = 31 * _result + (reportableInformation != null ? reportableInformation.hashCode() : 0);
			_result = 31 * _result + (collateralDetails != null ? collateralDetails.hashCode() : 0);
			_result = 31 * _result + (eventIdentifier != null ? eventIdentifier.hashCode() : 0);
			_result = 31 * _result + (level != null ? level.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReportableValuationBuilder {" +
				"valuationDetails=" + this.valuationDetails + ", " +
				"reportableInformation=" + this.reportableInformation + ", " +
				"collateralDetails=" + this.collateralDetails + ", " +
				"eventIdentifier=" + this.eventIdentifier + ", " +
				"level=" + this.level +
			'}';
		}
	}
}
