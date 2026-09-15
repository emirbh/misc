package iso20022.auth030.hkma.tr;

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
import iso20022.auth030.hkma.tr.meta.NotionalAmountLegs5__1Meta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates the monetary or converted amount for the derivatives transaction.
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalAmountLegs5__1", builder=NotionalAmountLegs5__1.NotionalAmountLegs5__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="NotionalAmountLegs5__1", model="iso20022", builder=NotionalAmountLegs5__1.NotionalAmountLegs5__1BuilderImpl.class, version="${project.version}")
public interface NotionalAmountLegs5__1 extends RosettaModelObject {

	NotionalAmountLegs5__1Meta metaData = new NotionalAmountLegs5__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Notional amount of leg 1 which indicates monetary or converted amount for the derivatives transaction.
	 */
	NotionalAmount5__1 getFrstLeg();
	/**
	 * Notional amount of leg 2 which indicates monetary or converted amount for the derivatives transaction.
	 */
	NotionalAmount6__1 getScndLeg();

	/*********************** Build Methods  ***********************/
	NotionalAmountLegs5__1 build();
	
	NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder toBuilder();
	
	static NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder builder() {
		return new NotionalAmountLegs5__1.NotionalAmountLegs5__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalAmountLegs5__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends NotionalAmountLegs5__1> getType() {
		return NotionalAmountLegs5__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("frstLeg"), processor, NotionalAmount5__1.class, getFrstLeg());
		processRosetta(path.newSubPath("scndLeg"), processor, NotionalAmount6__1.class, getScndLeg());
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalAmountLegs5__1Builder extends NotionalAmountLegs5__1, RosettaModelObjectBuilder {
		NotionalAmount5__1.NotionalAmount5__1Builder getOrCreateFrstLeg();
		@Override
		NotionalAmount5__1.NotionalAmount5__1Builder getFrstLeg();
		NotionalAmount6__1.NotionalAmount6__1Builder getOrCreateScndLeg();
		@Override
		NotionalAmount6__1.NotionalAmount6__1Builder getScndLeg();
		NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder setFrstLeg(NotionalAmount5__1 frstLeg);
		NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder setScndLeg(NotionalAmount6__1 scndLeg);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("frstLeg"), processor, NotionalAmount5__1.NotionalAmount5__1Builder.class, getFrstLeg());
			processRosetta(path.newSubPath("scndLeg"), processor, NotionalAmount6__1.NotionalAmount6__1Builder.class, getScndLeg());
		}
		

		NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder prune();
	}

	/*********************** Immutable Implementation of NotionalAmountLegs5__1  ***********************/
	class NotionalAmountLegs5__1Impl implements NotionalAmountLegs5__1 {
		private final NotionalAmount5__1 frstLeg;
		private final NotionalAmount6__1 scndLeg;
		
		protected NotionalAmountLegs5__1Impl(NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder builder) {
			this.frstLeg = ofNullable(builder.getFrstLeg()).map(f->f.build()).orElse(null);
			this.scndLeg = ofNullable(builder.getScndLeg()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("frstLeg")
		public NotionalAmount5__1 getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public NotionalAmount6__1 getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public NotionalAmountLegs5__1 build() {
			return this;
		}
		
		@Override
		public NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder toBuilder() {
			NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder builder) {
			ofNullable(getFrstLeg()).ifPresent(builder::setFrstLeg);
			ofNullable(getScndLeg()).ifPresent(builder::setScndLeg);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalAmountLegs5__1 _that = getType().cast(o);
		
			if (!Objects.equals(frstLeg, _that.getFrstLeg())) return false;
			if (!Objects.equals(scndLeg, _that.getScndLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frstLeg != null ? frstLeg.hashCode() : 0);
			_result = 31 * _result + (scndLeg != null ? scndLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalAmountLegs5__1 {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalAmountLegs5__1  ***********************/
	class NotionalAmountLegs5__1BuilderImpl implements NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder {
	
		protected NotionalAmount5__1.NotionalAmount5__1Builder frstLeg;
		protected NotionalAmount6__1.NotionalAmount6__1Builder scndLeg;
		
		@Override
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("frstLeg")
		public NotionalAmount5__1.NotionalAmount5__1Builder getFrstLeg() {
			return frstLeg;
		}
		
		@Override
		public NotionalAmount5__1.NotionalAmount5__1Builder getOrCreateFrstLeg() {
			NotionalAmount5__1.NotionalAmount5__1Builder result;
			if (frstLeg!=null) {
				result = frstLeg;
			}
			else {
				result = frstLeg = NotionalAmount5__1.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.GETTER)
		@RuneAttribute("scndLeg")
		public NotionalAmount6__1.NotionalAmount6__1Builder getScndLeg() {
			return scndLeg;
		}
		
		@Override
		public NotionalAmount6__1.NotionalAmount6__1Builder getOrCreateScndLeg() {
			NotionalAmount6__1.NotionalAmount6__1Builder result;
			if (scndLeg!=null) {
				result = scndLeg;
			}
			else {
				result = scndLeg = NotionalAmount6__1.builder();
			}
			
			return result;
		}
		
		@RosettaAttribute("frstLeg")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("frstLeg")
		@Override
		public NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder setFrstLeg(NotionalAmount5__1 _frstLeg) {
			this.frstLeg = _frstLeg == null ? null : _frstLeg.toBuilder();
			return this;
		}
		
		@RosettaAttribute("scndLeg")
		@Accessor(AccessorType.SETTER)
		@RuneAttribute("scndLeg")
		@Override
		public NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder setScndLeg(NotionalAmount6__1 _scndLeg) {
			this.scndLeg = _scndLeg == null ? null : _scndLeg.toBuilder();
			return this;
		}
		
		@Override
		public NotionalAmountLegs5__1 build() {
			return new NotionalAmountLegs5__1.NotionalAmountLegs5__1Impl(this);
		}
		
		@Override
		public NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder prune() {
			if (frstLeg!=null && !frstLeg.prune().hasData()) frstLeg = null;
			if (scndLeg!=null && !scndLeg.prune().hasData()) scndLeg = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFrstLeg()!=null && getFrstLeg().hasData()) return true;
			if (getScndLeg()!=null && getScndLeg().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder o = (NotionalAmountLegs5__1.NotionalAmountLegs5__1Builder) other;
			
			merger.mergeRosetta(getFrstLeg(), o.getFrstLeg(), this::setFrstLeg);
			merger.mergeRosetta(getScndLeg(), o.getScndLeg(), this::setScndLeg);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalAmountLegs5__1 _that = getType().cast(o);
		
			if (!Objects.equals(frstLeg, _that.getFrstLeg())) return false;
			if (!Objects.equals(scndLeg, _that.getScndLeg())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (frstLeg != null ? frstLeg.hashCode() : 0);
			_result = 31 * _result + (scndLeg != null ? scndLeg.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalAmountLegs5__1Builder {" +
				"frstLeg=" + this.frstLeg + ", " +
				"scndLeg=" + this.scndLeg +
			'}';
		}
	}
}
