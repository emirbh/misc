package drr.regulation.common;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.Accessor;
import com.rosetta.model.lib.annotations.AccessorType;
import com.rosetta.model.lib.annotations.Multi;
import com.rosetta.model.lib.annotations.Required;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.annotations.RosettaIgnore;
import com.rosetta.model.lib.annotations.RuneAttribute;
import com.rosetta.model.lib.annotations.RuneDataType;
import com.rosetta.model.lib.annotations.RuneIgnore;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import drr.base.margin.CollateralDetails;
import drr.base.trade.ReportableInformationBase;
import drr.regulation.common.meta.RegimeReportableCollateralMeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * Specifies a reportable collateral with a reporting side for each regime.
 * @version 7.7.0
 */
@RosettaDataType(value="RegimeReportableCollateral", builder=RegimeReportableCollateral.RegimeReportableCollateralBuilderImpl.class, version="7.7.0")
@RuneDataType(value="RegimeReportableCollateral", model="drr", builder=RegimeReportableCollateral.RegimeReportableCollateralBuilderImpl.class, version="7.7.0")
public interface RegimeReportableCollateral extends ReportableCollateral {

	RegimeReportableCollateralMeta metaData = new RegimeReportableCollateralMeta();

	/*********************** Getter Methods  ***********************/
	List<? extends RegimeReportingSide> getRegimeReportingSide();

	/*********************** Build Methods  ***********************/
	RegimeReportableCollateral build();
	
	RegimeReportableCollateral.RegimeReportableCollateralBuilder toBuilder();
	
	static RegimeReportableCollateral.RegimeReportableCollateralBuilder builder() {
		return new RegimeReportableCollateral.RegimeReportableCollateralBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RegimeReportableCollateral> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends RegimeReportableCollateral> getType() {
		return RegimeReportableCollateral.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.class, getCollateralDetails());
		processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.class, getReportableInformation());
		processRosetta(path.newSubPath("regimeReportingSide"), processor, RegimeReportingSide.class, getRegimeReportingSide());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RegimeReportableCollateralBuilder extends RegimeReportableCollateral, ReportableCollateral.ReportableCollateralBuilder {
		RegimeReportingSide.RegimeReportingSideBuilder getOrCreateRegimeReportingSide(int index);
		@Override
		List<? extends RegimeReportingSide.RegimeReportingSideBuilder> getRegimeReportingSide();
		@Override
		RegimeReportableCollateral.RegimeReportableCollateralBuilder setCollateralDetails(CollateralDetails collateralDetails);
		@Override
		RegimeReportableCollateral.RegimeReportableCollateralBuilder setReportableInformation(ReportableInformationBase reportableInformation);
		@Override
		RegimeReportableCollateral.RegimeReportableCollateralBuilder setReportableInformation(ReportableInformation reportableInformation);
		RegimeReportableCollateral.RegimeReportableCollateralBuilder addRegimeReportingSide(RegimeReportingSide regimeReportingSide);
		RegimeReportableCollateral.RegimeReportableCollateralBuilder addRegimeReportingSide(RegimeReportingSide regimeReportingSide, int idx);
		RegimeReportableCollateral.RegimeReportableCollateralBuilder addRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSide);
		RegimeReportableCollateral.RegimeReportableCollateralBuilder setRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSide);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collateralDetails"), processor, CollateralDetails.CollateralDetailsBuilder.class, getCollateralDetails());
			processRosetta(path.newSubPath("reportableInformation"), processor, ReportableInformation.ReportableInformationBuilder.class, getReportableInformation());
			processRosetta(path.newSubPath("regimeReportingSide"), processor, RegimeReportingSide.RegimeReportingSideBuilder.class, getRegimeReportingSide());
		}
		

		RegimeReportableCollateral.RegimeReportableCollateralBuilder prune();
	}

	/*********************** Immutable Implementation of RegimeReportableCollateral  ***********************/
	class RegimeReportableCollateralImpl extends ReportableCollateral.ReportableCollateralImpl implements RegimeReportableCollateral {
		private final List<? extends RegimeReportingSide> regimeReportingSide;
		
		protected RegimeReportableCollateralImpl(RegimeReportableCollateral.RegimeReportableCollateralBuilder builder) {
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
		public RegimeReportableCollateral build() {
			return this;
		}
		
		@Override
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder toBuilder() {
			RegimeReportableCollateral.RegimeReportableCollateralBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RegimeReportableCollateral.RegimeReportableCollateralBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getRegimeReportingSide()).ifPresent(builder::setRegimeReportingSide);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegimeReportableCollateral _that = getType().cast(o);
		
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
			return "RegimeReportableCollateral {" +
				"regimeReportingSide=" + this.regimeReportingSide +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of RegimeReportableCollateral  ***********************/
	class RegimeReportableCollateralBuilderImpl extends ReportableCollateral.ReportableCollateralBuilderImpl implements RegimeReportableCollateral.RegimeReportableCollateralBuilder {
	
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
		
		@RosettaAttribute("collateralDetails")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("collateralDetails")
		@Override
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder setCollateralDetails(CollateralDetails _collateralDetails) {
			this.collateralDetails = _collateralDetails == null ? null : _collateralDetails.toBuilder();
			return this;
		}
		
		@RosettaAttribute("reportableInformation")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("reportableInformation")
		@Override
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder setReportableInformation(ReportableInformation _reportableInformation) {
			this.reportableInformation = _reportableInformation == null ? null : _reportableInformation.toBuilder();
			return this;
		}
		
		@RosettaIgnore
		@RuneIgnore
		@Override
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder setReportableInformation(ReportableInformationBase _reportableInformation) {
			final ReportableInformation ifThenElseResult;
			if (_reportableInformation == null) {
				ifThenElseResult = null;
			} else {
				ifThenElseResult = _reportableInformation instanceof ReportableInformation ? ReportableInformation.class.cast(_reportableInformation) : null;
			}
			return setReportableInformation(ifThenElseResult);
		}
		
		@RosettaAttribute("regimeReportingSide")
		@Accessor(AccessorType.ADDER)
		@Multi
		@RuneAttribute("regimeReportingSide")
		@Override
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder addRegimeReportingSide(RegimeReportingSide _regimeReportingSide) {
			if (_regimeReportingSide != null) {
				this.regimeReportingSide.add(_regimeReportingSide.toBuilder());
			}
			return this;
		}
		
		@Override
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder addRegimeReportingSide(RegimeReportingSide _regimeReportingSide, int idx) {
			getIndex(this.regimeReportingSide, idx, () -> _regimeReportingSide.toBuilder());
			return this;
		}
		
		@Override
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder addRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSides) {
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
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder setRegimeReportingSide(List<? extends RegimeReportingSide> regimeReportingSides) {
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
		public RegimeReportableCollateral build() {
			return new RegimeReportableCollateral.RegimeReportableCollateralImpl(this);
		}
		
		@Override
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder prune() {
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
		public RegimeReportableCollateral.RegimeReportableCollateralBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			RegimeReportableCollateral.RegimeReportableCollateralBuilder o = (RegimeReportableCollateral.RegimeReportableCollateralBuilder) other;
			
			merger.mergeRosetta(getRegimeReportingSide(), o.getRegimeReportingSide(), this::getOrCreateRegimeReportingSide);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			RegimeReportableCollateral _that = getType().cast(o);
		
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
			return "RegimeReportableCollateralBuilder {" +
				"regimeReportingSide=" + this.regimeReportingSide +
			'}' + " " + super.toString();
		}
	}
}
