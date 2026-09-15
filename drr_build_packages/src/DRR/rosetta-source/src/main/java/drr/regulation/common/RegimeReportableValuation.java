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
import drr.regulation.common.meta.RegimeReportableValuationMeta;
import drr.standards.iso.ReportLevelEnum;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies a reportable valuation with a reporting side for each regime.
 * @version 7.7.0
 */
@RosettaDataType(value="RegimeReportableValuation", builder=RegimeReportableValuation.RegimeReportableValuationBuilderImpl.class, version="7.7.0")
@RuneDataType(value="RegimeReportableValuation", model="drr", builder=RegimeReportableValuation.RegimeReportableValuationBuilderImpl.class, version="7.7.0")
public interface RegimeReportableValuation extends ReportableValuation {

	RegimeReportableValuationMeta metaData = new RegimeReportableValuationMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends RegimeReportingSide> getRegimeReportingSide();

	/*********************** Build Methods  ***********************/
	RegimeReportableValuation build();
	
	RegimeReportableValuation.RegimeReportableValuationBuilder toBuilder();
	
	static RegimeReportableValuation.RegimeReportableValuationBuilder builder() {
		return new RegimeReportableValuation.RegimeReportableValuationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegimeReportableValuation> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegimeReportableValuation> getType() {
		return RegimeReportableValuation.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("valuationDetails"), processor, ValuationDetails.class, getValuationDetails());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.class, getReportableInformation());
		processRosetta(path.newSubPath("collateralDetails"), processor, Collateral.class, getCollateralDetails());
		processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.class, getEventIdentifier());
		processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
		processRosetta(path.newSubPath("regimeReportingSide"), processor, RegimeReportingSide.class, getRegimeReportingSide());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegimeReportableValuationBuilder extends RegimeReportableValuation, ReportableValuation.ReportableValuationBuilder {
		RegimeReportingSide.RegimeReportingSideBuilder getOrCreateRegimeReportingSide(int index);
		@Override
		List<? extends RegimeReportingSide.RegimeReportingSideBuilder> getRegimeReportingSide();
		@Override
		RegimeReportableValuation.RegimeReportableValuationBuilder setValuationDetails(ValuationDetails valuationDetails);
		@Override
		RegimeReportableValuation.RegimeReportableValuationBuilder setReportableInformation(ReportableInformation reportableInformation);
		@Override
		RegimeReportableValuation.RegimeReportableValuationBuilder setCollateralDetails(Collateral collateralDetails);
		@Override
		RegimeReportableValuation.RegimeReportableValuationBuilder addEventIdentifier(Identifier eventIdentifier);
		@Override
		RegimeReportableValuation.RegimeReportableValuationBuilder addEventIdentifier(Identifier eventIdentifier, int idx);
		@Override
		RegimeReportableValuation.RegimeReportableValuationBuilder addEventIdentifier(List<? extends Identifier> eventIdentifier);
		@Override
		RegimeReportableValuation.RegimeReportableValuationBuilder setEventIdentifier(List<? extends Identifier> eventIdentifier);
		@Override
		RegimeReportableValuation.RegimeReportableValuationBuilder setLevel(ReportLevelEnum level);
		RegimeReportableValuation.RegimeReportableValuationBuilder addRegimeReportingSide(RegimeReportingSide regimeReportingSide);
		RegimeReportableValuation.RegimeReportableValuationBuilder addRegimeReportingSide(RegimeReportingSide regimeReportingSide, int idx);
		RegimeReportableValuation.RegimeReportableValuationBuilder addRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSide);
		RegimeReportableValuation.RegimeReportableValuationBuilder setRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSide);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("valuationDetails"), processor, ValuationDetails.ValuationDetailsBuilder.class, getValuationDetails());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.ReportableInformationBuilder.class, getReportableInformation());
			processRosetta(path.newSubPath("collateralDetails"), processor, Collateral.CollateralBuilder.class, getCollateralDetails());
			processRosetta(path.newSubPath("eventIdentifier"), processor, Identifier.IdentifierBuilder.class, getEventIdentifier());
			processor.processBasic(path.newSubPath("level"), ReportLevelEnum.class, getLevel(), this);
			processRosetta(path.newSubPath("regimeReportingSide"), processor, RegimeReportingSide.RegimeReportingSideBuilder.class, getRegimeReportingSide());
		}
		

		RegimeReportableValuation.RegimeReportableValuationBuilder prune();
	}

	/*********************** Immutable Implementation of RegimeReportableValuation  ***********************/
	class RegimeReportableValuationImpl extends ReportableValuation.ReportableValuationImpl implements RegimeReportableValuation {
		private final List<? extends RegimeReportingSide> regimeReportingSide;
		
		protected RegimeReportableValuationImpl(RegimeReportableValuation.RegimeReportableValuationBuilder builder) {
			super(builder);
			this.regimeReportingSide = ofNullable(builder.getRegimeReportingSide()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("regimeReportingSide")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("regimeReportingSide")
		public List<? extends RegimeReportingSide> getRegimeReportingSide() {
			return regimeReportingSide;
		}
		
		@Override
		public RegimeReportableValuation build() {
			return this;
		}
		
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder toBuilder() {
			RegimeReportableValuation.RegimeReportableValuationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegimeReportableValuation.RegimeReportableValuationBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRegimeReportingSide()).ifPresent(builder::setRegimeReportingSide);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegimeReportableValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(regimeReportingSide, _that.getRegimeReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (regimeReportingSide != null ? regimeReportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeReportableValuation {" +
				"regimeReportingSide=" + this.regimeReportingSide +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegimeReportableValuation  ***********************/
	class RegimeReportableValuationBuilderImpl extends ReportableValuation.ReportableValuationBuilderImpl implements RegimeReportableValuation.RegimeReportableValuationBuilder {
	
		protected List<RegimeReportingSide.RegimeReportingSideBuilder> regimeReportingSide = new ArrayList<>();
		
		@Override
		@RosettaAttribute("regimeReportingSide")
		@Accessor(AccessorType.GETTER)
		@Multi
		@RuneAttribute("regimeReportingSide")
		public List<? extends RegimeReportingSide.RegimeReportingSideBuilder> getRegimeReportingSide() {
			return regimeReportingSide;
		}
		
		@Override
		public RegimeReportingSide.RegimeReportingSideBuilder getOrCreateRegimeReportingSide(int index) {
			if (regimeReportingSide==null) {
				this.regimeReportingSide = new ArrayList<>();
			}
			return getIndex(regimeReportingSide, index, () -> {
						RegimeReportingSide.RegimeReportingSideBuilder newRegimeReportingSide = RegimeReportingSide.builder();
						return newRegimeReportingSide;
					});
		}
		
		@RosettaAttribute("valuationDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("valuationDetails")
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder setValuationDetails(ValuationDetails _valuationDetails) {
			this.valuationDetails = _valuationDetails == null ? null : _valuationDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder setReportableInformation(ReportableInformation _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralDetails")
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder setCollateralDetails(Collateral _collateralDetails) {
			this.collateralDetails = _collateralDetails == null ? null : _collateralDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("eventIdentifier")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("eventIdentifier")
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder addEventIdentifier(Identifier _eventIdentifier) {
			if (_eventIdentifier != null) {
				this.eventIdentifier.add(_eventIdentifier.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder addEventIdentifier(Identifier _eventIdentifier, int idx) {
			getIndex(this.eventIdentifier, idx, () -> _eventIdentifier.toBuilder());
			return this;
		}
		
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder addEventIdentifier(List<? extends Identifier> eventIdentifiers) {
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
		public RegimeReportableValuation.RegimeReportableValuationBuilder setEventIdentifier(List<? extends Identifier> eventIdentifiers) {
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
		public RegimeReportableValuation.RegimeReportableValuationBuilder setLevel(ReportLevelEnum _level) {
			this.level = _level == null ? null : _level;
			return this;
		}
		
		@RosettaAttribute("regimeReportingSide")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("regimeReportingSide")
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder addRegimeReportingSide(RegimeReportingSide _regimeReportingSide) {
			if (_regimeReportingSide != null) {
				this.regimeReportingSide.add(_regimeReportingSide.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder addRegimeReportingSide(RegimeReportingSide _regimeReportingSide, int idx) {
			getIndex(this.regimeReportingSide, idx, () -> _regimeReportingSide.toBuilder());
			return this;
		}
		
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder addRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSides) {
			if (regimeReportingSides != null) {
				for (final RegimeReportingSide toAdd : regimeReportingSides) {
					this.regimeReportingSide.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@RosettaAttribute("regimeReportingSide")
		@Accessor(AccessorType.SETTER)
		@Multi
		@RuneAttribute("regimeReportingSide")
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder setRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSides) {
			if (regimeReportingSides == null) {
				this.regimeReportingSide = new ArrayList<>();
			} else {
				this.regimeReportingSide = regimeReportingSides.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		@Override
		public RegimeReportableValuation build() {
			return new RegimeReportableValuation.RegimeReportableValuationImpl(this);
		}
		
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder prune() {
			super.prune();
			regimeReportingSide = regimeReportingSide.stream().filter(b->b!=null).<RegimeReportingSide.RegimeReportingSideBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getRegimeReportingSide()!=null && getRegimeReportingSide().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeReportableValuation.RegimeReportableValuationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegimeReportableValuation.RegimeReportableValuationBuilder o = (RegimeReportableValuation.RegimeReportableValuationBuilder) other;
			
			merger.mergeRosetta(getRegimeReportingSide(), o.getRegimeReportingSide(), this::getOrCreateRegimeReportingSide);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegimeReportableValuation _that = getType().cast(o);
		
			if (!ListEquals.listEquals(regimeReportingSide, _that.getRegimeReportingSide())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (regimeReportingSide != null ? regimeReportingSide.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RegimeReportableValuationBuilder {" +
				"regimeReportingSide=" + this.regimeReportingSide +
			'}' + " " + super.toString();
		}
	}
}
