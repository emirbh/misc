package iso20022.auth108.iso;

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
import iso20022.auth108.iso.meta.MarginCollateralReport4Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Details of margin collateral agreement between counterparties.
 * @version ${project.version}
 */
@RosettaDataType(value="MarginCollateralReport4", builder=MarginCollateralReport4.MarginCollateralReport4BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MarginCollateralReport4", model="iso20022", builder=MarginCollateralReport4.MarginCollateralReport4BuilderImpl.class, version="${project.version}")
public interface MarginCollateralReport4 extends RosettaModelObject {

	MarginCollateralReport4Meta metaData = new MarginCollateralReport4Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the unique code assigned by the reporting counterparty to the portfolio if the collateral is posted on a portfolio basis.    Usage:  NoCode is reported if the collateralisation was performed on a transaction level basis, or if there is no collateral agreement or if no collateral is posted or received.
	 */
	CollateralPortfolioCode5Choice getCollPrtflCd();
	/**
	 * Indicates the type of collateral agreement existing between the counterparties.
	 */
	CollateralisationType3Code getCollstnCtgy();
	/**
	 * Indicates the date and time of the last collateral amount determination or calculation.
	 */
	ZonedDateTime getTmStmp();

	/*********************** Build Methods  ***********************/
	MarginCollateralReport4 build();
	
	MarginCollateralReport4.MarginCollateralReport4Builder toBuilder();
	
	static MarginCollateralReport4.MarginCollateralReport4Builder builder() {
		return new MarginCollateralReport4.MarginCollateralReport4BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginCollateralReport4> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginCollateralReport4> getType() {
		return MarginCollateralReport4.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode5Choice.class, getCollPrtflCd());
		processor.processBasic(path.newSubPath("collstnCtgy"), CollateralisationType3Code.class, getCollstnCtgy(), this);
		processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginCollateralReport4Builder extends MarginCollateralReport4, RosettaModelObjectBuilder {
		CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder getOrCreateCollPrtflCd();
		@Override
		CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder getCollPrtflCd();
		MarginCollateralReport4.MarginCollateralReport4Builder setCollPrtflCd(CollateralPortfolioCode5Choice collPrtflCd);
		MarginCollateralReport4.MarginCollateralReport4Builder setCollstnCtgy(CollateralisationType3Code collstnCtgy);
		MarginCollateralReport4.MarginCollateralReport4Builder setTmStmp(ZonedDateTime tmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder.class, getCollPrtflCd());
			processor.processBasic(path.newSubPath("collstnCtgy"), CollateralisationType3Code.class, getCollstnCtgy(), this);
			processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
		}
		

		MarginCollateralReport4.MarginCollateralReport4Builder prune();
	}

	/*********************** Immutable Implementation of MarginCollateralReport4  ***********************/
	class MarginCollateralReport4Impl implements MarginCollateralReport4 {
		private final CollateralPortfolioCode5Choice collPrtflCd;
		private final CollateralisationType3Code collstnCtgy;
		private final ZonedDateTime tmStmp;
		
		protected MarginCollateralReport4Impl(MarginCollateralReport4.MarginCollateralReport4Builder builder) {
			this.collPrtflCd = ofNullable(builder.getCollPrtflCd()).map(f->f.build()).orElse(null);
			this.collstnCtgy = builder.getCollstnCtgy();
			this.tmStmp = builder.getTmStmp();
		}
		
		@Override
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode5Choice getCollPrtflCd() {
			return collPrtflCd;
		}
		
		@Override
		@RosettaAttribute("collstnCtgy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collstnCtgy")
		public CollateralisationType3Code getCollstnCtgy() {
			return collstnCtgy;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@Override
		public MarginCollateralReport4 build() {
			return this;
		}
		
		@Override
		public MarginCollateralReport4.MarginCollateralReport4Builder toBuilder() {
			MarginCollateralReport4.MarginCollateralReport4Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginCollateralReport4.MarginCollateralReport4Builder builder) {
			ofNullable(getCollPrtflCd()).ifPresent(builder::setCollPrtflCd);
			ofNullable(getCollstnCtgy()).ifPresent(builder::setCollstnCtgy);
			ofNullable(getTmStmp()).ifPresent(builder::setTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginCollateralReport4 _that = getType().cast(o);
		
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(collstnCtgy, _that.getCollstnCtgy())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (collstnCtgy != null ? collstnCtgy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginCollateralReport4 {" +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"collstnCtgy=" + this.collstnCtgy + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginCollateralReport4  ***********************/
	class MarginCollateralReport4BuilderImpl implements MarginCollateralReport4.MarginCollateralReport4Builder {
	
		protected CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder collPrtflCd;
		protected CollateralisationType3Code collstnCtgy;
		protected ZonedDateTime tmStmp;
		
		@Override
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder getCollPrtflCd() {
			return collPrtflCd;
		}
		
		@Override
		public CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder getOrCreateCollPrtflCd() {
			CollateralPortfolioCode5Choice.CollateralPortfolioCode5ChoiceBuilder result;
			if (collPrtflCd!=null) {
				result = collPrtflCd;
			}
			else {
				result = collPrtflCd = CollateralPortfolioCode5Choice.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("collstnCtgy")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collstnCtgy")
		public CollateralisationType3Code getCollstnCtgy() {
			return collstnCtgy;
		}
		
		@Override
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		@Override
		public MarginCollateralReport4.MarginCollateralReport4Builder setCollPrtflCd(CollateralPortfolioCode5Choice _collPrtflCd) {
			this.collPrtflCd = _collPrtflCd == null ? null : _collPrtflCd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collstnCtgy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collstnCtgy")
		@Override
		public MarginCollateralReport4.MarginCollateralReport4Builder setCollstnCtgy(CollateralisationType3Code _collstnCtgy) {
			this.collstnCtgy = _collstnCtgy == null ? null : _collstnCtgy;
			return this;
		}
		
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("tmStmp")
		@Override
		public MarginCollateralReport4.MarginCollateralReport4Builder setTmStmp(ZonedDateTime _tmStmp) {
			this.tmStmp = _tmStmp == null ? null : _tmStmp;
			return this;
		}
		
		@Override
		public MarginCollateralReport4 build() {
			return new MarginCollateralReport4.MarginCollateralReport4Impl(this);
		}
		
		@Override
		public MarginCollateralReport4.MarginCollateralReport4Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginCollateralReport4.MarginCollateralReport4Builder prune() {
			if (collPrtflCd!=null && !collPrtflCd.prune().hasData()) collPrtflCd = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCollPrtflCd()!=null && getCollPrtflCd().hasData()) return true;
			if (getCollstnCtgy()!=null) return true;
			if (getTmStmp()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginCollateralReport4.MarginCollateralReport4Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginCollateralReport4.MarginCollateralReport4Builder o = (MarginCollateralReport4.MarginCollateralReport4Builder) other;
			
			merger.mergeRosetta(getCollPrtflCd(), o.getCollPrtflCd(), this::setCollPrtflCd);
			
			merger.mergeBasic(getCollstnCtgy(), o.getCollstnCtgy(), this::setCollstnCtgy);
			merger.mergeBasic(getTmStmp(), o.getTmStmp(), this::setTmStmp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginCollateralReport4 _that = getType().cast(o);
		
			if (!Objects.equals(collPrtflCd, _that.getCollPrtflCd())) return false;
			if (!Objects.equals(collstnCtgy, _that.getCollstnCtgy())) return false;
			if (!Objects.equals(tmStmp, _that.getTmStmp())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (collPrtflCd != null ? collPrtflCd.hashCode() : 0);
			_result = 31 * _result + (collstnCtgy != null ? collstnCtgy.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (tmStmp != null ? tmStmp.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MarginCollateralReport4Builder {" +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"collstnCtgy=" + this.collstnCtgy + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}
}
