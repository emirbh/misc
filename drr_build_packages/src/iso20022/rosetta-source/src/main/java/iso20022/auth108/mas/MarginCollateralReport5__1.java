package iso20022.auth108.mas;

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
import iso20022.auth108.mas.meta.MarginCollateralReport5__1Meta;
import java.time.ZonedDateTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="MarginCollateralReport5__1", builder=MarginCollateralReport5__1.MarginCollateralReport5__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="MarginCollateralReport5__1", model="iso20022", builder=MarginCollateralReport5__1.MarginCollateralReport5__1BuilderImpl.class, version="${project.version}")
public interface MarginCollateralReport5__1 extends RosettaModelObject {

	MarginCollateralReport5__1Meta metaData = new MarginCollateralReport5__1Meta();

	/*********************** Getter Methods  ***********************/
	CollateralPortfolioCode6Choice__1 getCollPrtflCd();
	CollateralisationType3Code getCollstnCtgy();
	ZonedDateTime getTmStmp();

	/*********************** Build Methods  ***********************/
	MarginCollateralReport5__1 build();
	
	MarginCollateralReport5__1.MarginCollateralReport5__1Builder toBuilder();
	
	static MarginCollateralReport5__1.MarginCollateralReport5__1Builder builder() {
		return new MarginCollateralReport5__1.MarginCollateralReport5__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MarginCollateralReport5__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends MarginCollateralReport5__1> getType() {
		return MarginCollateralReport5__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode6Choice__1.class, getCollPrtflCd());
		processor.processBasic(path.newSubPath("collstnCtgy"), CollateralisationType3Code.class, getCollstnCtgy(), this);
		processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MarginCollateralReport5__1Builder extends MarginCollateralReport5__1, RosettaModelObjectBuilder {
		CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder getOrCreateCollPrtflCd();
		@Override
		CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder getCollPrtflCd();
		MarginCollateralReport5__1.MarginCollateralReport5__1Builder setCollPrtflCd(CollateralPortfolioCode6Choice__1 collPrtflCd);
		MarginCollateralReport5__1.MarginCollateralReport5__1Builder setCollstnCtgy(CollateralisationType3Code collstnCtgy);
		MarginCollateralReport5__1.MarginCollateralReport5__1Builder setTmStmp(ZonedDateTime tmStmp);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("collPrtflCd"), processor, CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder.class, getCollPrtflCd());
			processor.processBasic(path.newSubPath("collstnCtgy"), CollateralisationType3Code.class, getCollstnCtgy(), this);
			processor.processBasic(path.newSubPath("tmStmp"), ZonedDateTime.class, getTmStmp(), this);
		}
		

		MarginCollateralReport5__1.MarginCollateralReport5__1Builder prune();
	}

	/*********************** Immutable Implementation of MarginCollateralReport5__1  ***********************/
	class MarginCollateralReport5__1Impl implements MarginCollateralReport5__1 {
		private final CollateralPortfolioCode6Choice__1 collPrtflCd;
		private final CollateralisationType3Code collstnCtgy;
		private final ZonedDateTime tmStmp;
		
		protected MarginCollateralReport5__1Impl(MarginCollateralReport5__1.MarginCollateralReport5__1Builder builder) {
			this.collPrtflCd = ofNullable(builder.getCollPrtflCd()).map(f->f.build()).orElse(null);
			this.collstnCtgy = builder.getCollstnCtgy();
			this.tmStmp = builder.getTmStmp();
		}
		
		@Override
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode6Choice__1 getCollPrtflCd() {
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
		@Required
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@Override
		public MarginCollateralReport5__1 build() {
			return this;
		}
		
		@Override
		public MarginCollateralReport5__1.MarginCollateralReport5__1Builder toBuilder() {
			MarginCollateralReport5__1.MarginCollateralReport5__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MarginCollateralReport5__1.MarginCollateralReport5__1Builder builder) {
			ofNullable(getCollPrtflCd()).ifPresent(builder::setCollPrtflCd);
			ofNullable(getCollstnCtgy()).ifPresent(builder::setCollstnCtgy);
			ofNullable(getTmStmp()).ifPresent(builder::setTmStmp);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginCollateralReport5__1 _that = getType().cast(o);
		
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
			return "MarginCollateralReport5__1 {" +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"collstnCtgy=" + this.collstnCtgy + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}

	/*********************** Builder Implementation of MarginCollateralReport5__1  ***********************/
	class MarginCollateralReport5__1BuilderImpl implements MarginCollateralReport5__1.MarginCollateralReport5__1Builder {
	
		protected CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder collPrtflCd;
		protected CollateralisationType3Code collstnCtgy;
		protected ZonedDateTime tmStmp;
		
		@Override
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		public CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder getCollPrtflCd() {
			return collPrtflCd;
		}
		
		@Override
		public CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder getOrCreateCollPrtflCd() {
			CollateralPortfolioCode6Choice__1.CollateralPortfolioCode6Choice__1Builder result;
			if (collPrtflCd!=null) {
				result = collPrtflCd;
			}
			else {
				result = collPrtflCd = CollateralPortfolioCode6Choice__1.builder();
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
		@Required
		@RuneAttribute("tmStmp")
		public ZonedDateTime getTmStmp() {
			return tmStmp;
		}
		
		@RosettaAttribute("collPrtflCd")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collPrtflCd")
		@Override
		public MarginCollateralReport5__1.MarginCollateralReport5__1Builder setCollPrtflCd(CollateralPortfolioCode6Choice__1 _collPrtflCd) {
			this.collPrtflCd = _collPrtflCd == null ? null : _collPrtflCd.toBuilder();
			return this;
		}
		
		@RosettaAttribute("collstnCtgy")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("collstnCtgy")
		@Override
		public MarginCollateralReport5__1.MarginCollateralReport5__1Builder setCollstnCtgy(CollateralisationType3Code _collstnCtgy) {
			this.collstnCtgy = _collstnCtgy == null ? null : _collstnCtgy;
			return this;
		}
		
		@RosettaAttribute("tmStmp")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("tmStmp")
		@Override
		public MarginCollateralReport5__1.MarginCollateralReport5__1Builder setTmStmp(ZonedDateTime _tmStmp) {
			this.tmStmp = _tmStmp == null ? null : _tmStmp;
			return this;
		}
		
		@Override
		public MarginCollateralReport5__1 build() {
			return new MarginCollateralReport5__1.MarginCollateralReport5__1Impl(this);
		}
		
		@Override
		public MarginCollateralReport5__1.MarginCollateralReport5__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MarginCollateralReport5__1.MarginCollateralReport5__1Builder prune() {
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
		public MarginCollateralReport5__1.MarginCollateralReport5__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MarginCollateralReport5__1.MarginCollateralReport5__1Builder o = (MarginCollateralReport5__1.MarginCollateralReport5__1Builder) other;
			
			merger.mergeRosetta(getCollPrtflCd(), o.getCollPrtflCd(), this::setCollPrtflCd);
			
			merger.mergeBasic(getCollstnCtgy(), o.getCollstnCtgy(), this::setCollstnCtgy);
			merger.mergeBasic(getTmStmp(), o.getTmStmp(), this::setTmStmp);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MarginCollateralReport5__1 _that = getType().cast(o);
		
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
			return "MarginCollateralReport5__1Builder {" +
				"collPrtflCd=" + this.collPrtflCd + ", " +
				"collstnCtgy=" + this.collstnCtgy + ", " +
				"tmStmp=" + this.tmStmp +
			'}';
		}
	}
}
