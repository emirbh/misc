package iso20022.auth030.fca;

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
import iso20022.auth030.fca.meta.Tranche3__1Meta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Indicates derivative contract was tranched.
 * @version ${project.version}
 */
@RosettaDataType(value="Tranche3__1", builder=Tranche3__1.Tranche3__1BuilderImpl.class, version="${project.version}")
@RuneDataType(value="Tranche3__1", model="iso20022", builder=Tranche3__1.Tranche3__1BuilderImpl.class, version="${project.version}")
public interface Tranche3__1 extends RosettaModelObject {

	Tranche3__1Meta metaData = new Tranche3__1Meta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Indicates the lower point at which the level of losses in the underlying portfolio reduces the notional of the tranche.
	 */
	BigDecimal getAttchmntPt();
	/**
	 * Indicates the point beyond which the losses in the underlying portfolio no longer reduce the notional of the tranche.
	 */
	BigDecimal getDtchmntPt();

	/*********************** Build Methods  ***********************/
	Tranche3__1 build();
	
	Tranche3__1.Tranche3__1Builder toBuilder();
	
	static Tranche3__1.Tranche3__1Builder builder() {
		return new Tranche3__1.Tranche3__1BuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends Tranche3__1> metaData() {
		return metaData;
	}
	
	@Override
	@RuneAttribute("@type")
	default Class<? extends Tranche3__1> getType() {
		return Tranche3__1.class;
	}
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("attchmntPt"), BigDecimal.class, getAttchmntPt(), this);
		processor.processBasic(path.newSubPath("dtchmntPt"), BigDecimal.class, getDtchmntPt(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface Tranche3__1Builder extends Tranche3__1, RosettaModelObjectBuilder {
		Tranche3__1.Tranche3__1Builder setAttchmntPt(BigDecimal attchmntPt);
		Tranche3__1.Tranche3__1Builder setDtchmntPt(BigDecimal dtchmntPt);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("attchmntPt"), BigDecimal.class, getAttchmntPt(), this);
			processor.processBasic(path.newSubPath("dtchmntPt"), BigDecimal.class, getDtchmntPt(), this);
		}
		

		Tranche3__1.Tranche3__1Builder prune();
	}

	/*********************** Immutable Implementation of Tranche3__1  ***********************/
	class Tranche3__1Impl implements Tranche3__1 {
		private final BigDecimal attchmntPt;
		private final BigDecimal dtchmntPt;
		
		protected Tranche3__1Impl(Tranche3__1.Tranche3__1Builder builder) {
			this.attchmntPt = builder.getAttchmntPt();
			this.dtchmntPt = builder.getDtchmntPt();
		}
		
		@Override
		@RosettaAttribute("attchmntPt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("attchmntPt")
		public BigDecimal getAttchmntPt() {
			return attchmntPt;
		}
		
		@Override
		@RosettaAttribute("dtchmntPt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtchmntPt")
		public BigDecimal getDtchmntPt() {
			return dtchmntPt;
		}
		
		@Override
		public Tranche3__1 build() {
			return this;
		}
		
		@Override
		public Tranche3__1.Tranche3__1Builder toBuilder() {
			Tranche3__1.Tranche3__1Builder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Tranche3__1.Tranche3__1Builder builder) {
			ofNullable(getAttchmntPt()).ifPresent(builder::setAttchmntPt);
			ofNullable(getDtchmntPt()).ifPresent(builder::setDtchmntPt);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Tranche3__1 _that = getType().cast(o);
		
			if (!Objects.equals(attchmntPt, _that.getAttchmntPt())) return false;
			if (!Objects.equals(dtchmntPt, _that.getDtchmntPt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (attchmntPt != null ? attchmntPt.hashCode() : 0);
			_result = 31 * _result + (dtchmntPt != null ? dtchmntPt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Tranche3__1 {" +
				"attchmntPt=" + this.attchmntPt + ", " +
				"dtchmntPt=" + this.dtchmntPt +
			'}';
		}
	}

	/*********************** Builder Implementation of Tranche3__1  ***********************/
	class Tranche3__1BuilderImpl implements Tranche3__1.Tranche3__1Builder {
	
		protected BigDecimal attchmntPt;
		protected BigDecimal dtchmntPt;
		
		@Override
		@RosettaAttribute("attchmntPt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("attchmntPt")
		public BigDecimal getAttchmntPt() {
			return attchmntPt;
		}
		
		@Override
		@RosettaAttribute("dtchmntPt")
		@Accessor(AccessorType.GETTER)
		@Required
		@RuneAttribute("dtchmntPt")
		public BigDecimal getDtchmntPt() {
			return dtchmntPt;
		}
		
		@RosettaAttribute("attchmntPt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("attchmntPt")
		@Override
		public Tranche3__1.Tranche3__1Builder setAttchmntPt(BigDecimal _attchmntPt) {
			this.attchmntPt = _attchmntPt == null ? null : _attchmntPt;
			return this;
		}
		
		@RosettaAttribute("dtchmntPt")
		@Accessor(AccessorType.SETTER)
		@Required
		@RuneAttribute("dtchmntPt")
		@Override
		public Tranche3__1.Tranche3__1Builder setDtchmntPt(BigDecimal _dtchmntPt) {
			this.dtchmntPt = _dtchmntPt == null ? null : _dtchmntPt;
			return this;
		}
		
		@Override
		public Tranche3__1 build() {
			return new Tranche3__1.Tranche3__1Impl(this);
		}
		
		@Override
		public Tranche3__1.Tranche3__1Builder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Tranche3__1.Tranche3__1Builder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAttchmntPt()!=null) return true;
			if (getDtchmntPt()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Tranche3__1.Tranche3__1Builder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Tranche3__1.Tranche3__1Builder o = (Tranche3__1.Tranche3__1Builder) other;
			
			
			merger.mergeBasic(getAttchmntPt(), o.getAttchmntPt(), this::setAttchmntPt);
			merger.mergeBasic(getDtchmntPt(), o.getDtchmntPt(), this::setDtchmntPt);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Tranche3__1 _that = getType().cast(o);
		
			if (!Objects.equals(attchmntPt, _that.getAttchmntPt())) return false;
			if (!Objects.equals(dtchmntPt, _that.getDtchmntPt())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (attchmntPt != null ? attchmntPt.hashCode() : 0);
			_result = 31 * _result + (dtchmntPt != null ? dtchmntPt.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Tranche3__1Builder {" +
				"attchmntPt=" + this.attchmntPt + ", " +
				"dtchmntPt=" + this.dtchmntPt +
			'}';
		}
	}
}
